package com.ynufrd.mddds.fileservice.controller;

import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.fileservice.entity.FileObject;
import com.ynufrd.mddds.fileservice.exception.MinioFileException;
import com.ynufrd.mddds.fileservice.exception.MinioFileType;
import com.ynufrd.mddds.fileservice.service.FileService;
import com.ynufrd.mddds.fileservice.util.ContentTypeSelector;
import io.minio.StatObjectResponse;
import io.netty.util.internal.ObjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.apache.commons.io.IOUtils;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Created by wjs on 2022/08/02
 */
@Api(tags = "文件管理")
@RestController
@RequestMapping(value = "/file")
public class FileController {

    private final FileService fileService;

    public FileController(@Qualifier("minioServiceImpl") FileService fileService) {
        this.fileService = fileService;
    }


    @ApiOperation(value = "上传文件", notes = "上传文件", response = Result.class)
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Result<String> upload(@RequestPart(value = "file") MultipartFile file,
                            @RequestParam(value = "bucketName") String bucketName) {
        return Result.success(fileService.uploadFile(file, bucketName));
    }


    @ApiOperation(value = "删除文件", notes = "删除文件", response = Result.class)
    @DeleteMapping("/remove")
    public Result<?> remove(@Valid @RequestBody FileObject fileObject) {
        fileService.removeFile(fileObject.getBucketName(), fileObject.getFileName());
        return Result.success();
    }


    @ApiOperation(value = "预览图片", notes = "预览图片")
    @GetMapping("/previewPicture/{fileName}")
    public void previewPicture(@PathVariable("fileName") String objectName,
                               @RequestParam(value = "bucketName") String bucketName,
                               HttpServletResponse response) throws IOException {
        String fileType = objectName.substring(objectName.lastIndexOf(".")).toLowerCase(Locale.ROOT);
        String contentType = ContentTypeSelector.contentType.get(fileType);
        if (StringUtils.isEmpty(contentType)) {
            throw new MinioFileException(MinioFileType.FILE_UNSUPPORTED_OPERATION, "文件不支持操作！");
        }
        response.setContentType(contentType);
        try (ServletOutputStream out = response.getOutputStream()) {
            InputStream stream = fileService.getObject(bucketName, objectName);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = stream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            byte[] bytes = output.toByteArray();
            out.write(bytes);
            out.flush();
        }
    }


    @ApiOperation(value = "下载文件到本地", notes = "下载文件到本地")
    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable("fileName") String objectName,
                                           @RequestParam(value = "bucketName") String bucketName) throws Exception {
        ResponseEntity<byte[]> responseEntity = null;
        InputStream stream = null;
        ByteArrayOutputStream output = null;
        try {
            stream = fileService.getObject(bucketName, objectName);
            if (stream == null) {
                throw new MinioFileException(MinioFileType.FAILED_DOWNLOAD_FILE, "");
            }
            //用于转换byte
            output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = stream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            byte[] bytes = output.toByteArray();

            //设置header
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept-Ranges", "bytes");
            httpHeaders.add("Content-Length", bytes.length + "");
            objectName = new String(objectName.getBytes(StandardCharsets.UTF_8), "ISO8859-1");
            //把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
            httpHeaders.add("Content-disposition", "attachment; filename=" + objectName);
            httpHeaders.add("Content-Type", "text/plain;charset=utf-8");
            responseEntity = new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.CREATED);
        } finally {
            if (stream != null) {
                stream.close();
            }
            if (output != null) {
                output.close();
            }
        }
        return responseEntity;
    }

    @ApiOperation(value = "预览大文件", notes = "预览大文件")
    @GetMapping(value = "/preview/{fileName}")
    public void getVideoOutStream(@PathVariable(value = "fileName") String fileName,
                                  @RequestParam(value = "bucketName") String bucketName,
                                  HttpServletRequest request, HttpServletResponse response) {
        StatObjectResponse objectInfo = fileService.getObjectInfo(bucketName, fileName);
        String filenameExtension = StringUtils.getFilenameExtension(fileName).toLowerCase(Locale.ROOT);
        long fileSize = objectInfo.size();
        // Accept-Ranges: bytes
        response.setHeader("Accept-Ranges", "bytes");
        long startPos = 0;
        long endPos = fileSize - 1;
        String rangeHeader = request.getHeader("Range");
        if (!ObjectUtils.isEmpty(rangeHeader) && rangeHeader.startsWith("bytes=")) {

            try {
                // 情景一：RANGE: bytes=2000070- 情景二：RANGE: bytes=2000070-2000970
                String numRang = request.getHeader("Range").replaceAll("bytes=", "");
                if (numRang.startsWith("-")) {
                    endPos = fileSize - 1;
                    startPos = endPos - Long.parseLong(new String(numRang.getBytes(StandardCharsets.UTF_8), 1,
                            numRang.length() - 1)) + 1;
                } else if (numRang.endsWith("-")) {
                    endPos = fileSize - 1;
                    startPos = Long.parseLong(new String(numRang.getBytes(StandardCharsets.UTF_8), 0,
                            numRang.length() - 1));
                } else {
                    String[] strRange = numRang.split("-");
                    if (strRange.length == 2) {
                        startPos = Long.parseLong(strRange[0].trim());
                        endPos = Long.parseLong(strRange[1].trim());
                    } else {
                        startPos = Long.parseLong(numRang.replaceAll("-", "").trim());
                    }
                }

                if (startPos < 0 || endPos < 0 || endPos >= fileSize || startPos > endPos) {
                    // SC 要求的范围不满足
                    response.setStatus(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE);
                    return;
                }

                // 断点续传 状态码206
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
            } catch (NumberFormatException e) {
                startPos = 0;
            }
        }
        long rangLength = endPos - startPos + 1;
        response.setHeader("Content-Range", String.format("bytes %d-%d/%d", startPos, endPos, fileSize));
        response.addHeader("Content-Length", String.valueOf(rangLength));
        response.addHeader("Content-Type", ContentTypeSelector.contentType.get(filenameExtension));
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            BufferedInputStream bis = new BufferedInputStream(fileService.getObject(bucketName, fileName));
            bis.skip(startPos);
            IOUtils.copy(bis, bos);
        } catch (IOException e) {
            if (e instanceof ClientAbortException) {
                // ignore
            } else {
                throw new MinioFileException(MinioFileType.FILE_UNSUPPORTED_OPERATION,"文件不支持操作！");
            }
        }


    }
}
