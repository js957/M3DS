package com.ynufrd.mddds.fileservice.service;

import io.minio.StatObjectResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author fengdan
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file       文件
     * @param bucketName 存储空间(桶)
     * @return file url
     */
    String uploadFile(MultipartFile file, String bucketName);

    /**
     * 删除文件
     *
     * @param bucketName 存储空间(桶)
     * @param objectName 文件名
     */
    void removeFile(String bucketName, String objectName);

    /**
     * 获取文件
     *
     * @param bucketName 存储空间(桶)
     * @param objectName 文件名
     * @return 进制流
     */
    InputStream getObject(String bucketName, String objectName);


    /**
    *@Param:
    *@Author: wjs
    *@date: 16:03
     * 获取文件信息
    */
    public StatObjectResponse getObjectInfo(String bucketName, String objectName);
}
