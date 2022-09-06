package com.ynufrd.mddds.fileservice.service;


import com.ynufrd.mddds.fileservice.exception.MinioFileException;
import com.ynufrd.mddds.fileservice.exception.MinioFileType;
import com.ynufrd.mddds.fileservice.util.MinioFileUtil;
import io.minio.StatObjectResponse;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author fengdan
 */
@Slf4j
@Service("minioServiceImpl")
@RequiredArgsConstructor
public class MinIoFileServiceImpl implements FileService {

    private final MinioFileUtil minioFileUtil;

    @Override
    public String uploadFile(MultipartFile file, String bucketName) {
        try {
            return this.minioFileUtil.uploadFile(file, bucketName);
        } catch (IOException | ServerException | InsufficientDataException | ErrorResponseException | NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException | InternalException e) {
            log.error("文件上传失败:" + e.getMessage(), e);
            throw new MinioFileException();
        }
    }


    @Override
    public void removeFile(String bucketName, String objectName) {
        try {
            this.minioFileUtil.removeFile(bucketName, objectName);
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException | NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException | InternalException e) {
            log.error("文件删除失败:" + e.getMessage(), e);
            throw new MinioFileException(MinioFileType.FILE_REMOVE_FAILED, "文件删除失败");
        }
    }

    @Override
    public InputStream getObject(String salt, String objectName) {
        try {
            return this.minioFileUtil.getObject(salt, objectName);

        } catch (Exception e) {
            log.error("获取文件失败:" + e.getMessage(), e);
            throw new MinioFileException(MinioFileType.FILE_GET_FAILED, e.getMessage());
        }
    }

    @Override
    public StatObjectResponse getObjectInfo(String bucketName, String objectName){
        try {
            return this.minioFileUtil.getObjectInfo(bucketName,objectName);
        }catch (Exception e){
            log.error("获取文件信息失败" + e.getMessage(), e);
            throw new MinioFileException(MinioFileType.FILE_GET_FAILED, e.getMessage());
        }
    }

}
