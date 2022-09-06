package com.ynufrd.mddds.fileservice.util;

import com.ynufrd.mddds.fileservice.config.MinioProperties;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by wjs on 2022/08/02
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MinioFileUtil {

    private final MinioProperties minioProperties;

    private final MinioClient client;

    /**
     * 创建bucket
     *
     * @param bucketName 存储空间(桶)
     */
    public void createBucket(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        BucketExistsArgs build = BucketExistsArgs.builder().bucket(bucketName).build();
        //判断 bucketName 是否存在
        if (!client.bucketExists(build)) {
            client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 上传文件
     *
     * @param file       文件
     * @param bucketName 存储空间(桶)
     * @return file url
     */
    public String uploadFile(MultipartFile file, String bucketName) throws
            IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        //判断文件是否为空
        if (file == null || file.getSize() == 0) {
            return null;
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String fileName = bucketName;
        // 若是采集的数据，bucketName为：collection-video(audio)-用户id-实验id
        if (bucketName.trim().startsWith("collection")) {
            bucketName = bucketName.substring(0, 10);
            fileName = fileName + "-" +
                    System.currentTimeMillis() +
                    originalFilename.substring(originalFilename.lastIndexOf("."));
        }else{
            fileName = fileName + "_" +
                System.currentTimeMillis() + "_" + originalFilename;
        }
        //判断存储桶是否存在,不存在则创建
        createBucket(bucketName);


        //文件重名处理,bucketName+时间戳+随机数

        //上传
        client.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build());

        return fileName;
    }

    /**
     * 删除文件
     *
     * @param bucketName 存储空间(桶)
     * @param objectName ⽂件名称
     */
    public void removeFile(String bucketName, String objectName) throws
            ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        client.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 获取⽂件
     *
     * @param bucketName bucket名称
     * @param objectName ⽂件名称
     * @return ⼆进制流
     */
    public InputStream getObject(String bucketName, String objectName) throws Exception {
        return client.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }


    /**
     * 列出所有存储桶名称
     *
     * @return
     * @throws IOException
     * @throws XmlParserException
     * @throws NoSuchAlgorithmException
     * @throws InvalidResponseException
     * @throws InternalException
     * @throws InsufficientDataException
     * @throws IllegalArgumentException
     * @throws ErrorResponseException
     * @throws InvalidKeyException
     */
    public List<String> listBucketNames() throws InvalidKeyException, ErrorResponseException, IllegalArgumentException,
            InsufficientDataException, InternalException, InvalidResponseException,
            NoSuchAlgorithmException, XmlParserException, IOException, ServerException {
        List<Bucket> bucketList = listBuckets();
        List<String> bucketListName = new ArrayList<>();
        for (Bucket bucket : bucketList) {
            bucketListName.add(bucket.name());
        }
        return bucketListName;
    }

    /**
     * 列出所有存储桶
     *
     * @return
     * @throws IOException
     * @throws XmlParserException
     * @throws NoSuchAlgorithmException
     * @throws InvalidResponseException
     * @throws InternalException
     * @throws InsufficientDataException
     * @throws IllegalArgumentException
     * @throws ErrorResponseException
     * @throws InvalidKeyException
     */
    public List<Bucket> listBuckets() throws InvalidKeyException, ErrorResponseException, IllegalArgumentException,
            InsufficientDataException, InternalException, InvalidResponseException,
            NoSuchAlgorithmException, XmlParserException, IOException, ServerException {
        return client.listBuckets();
    }


    /**
     * @Param:
     * @Author: wjs
     * @date: 16:00
     * 获取文件信息
     */
    public StatObjectResponse getObjectInfo(String bucketName, String objectName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return client.statObject(StatObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build());
    }


}
