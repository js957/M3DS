package com.ynufrd.mddds.collectionservice.config;

/**
 * Created by wjs on 2022/08/23
 */
public class Constant {

    public static final String COLLECTION = "collection";
    public static final String COLLECTION_VIDEO = "collection-video";

    public static String getPreviewUri(String fileName, String bucketName) {
        return "/file/preview/" + fileName + "?bucketName=" + bucketName;
    }

    public static String getDownloadUri(String fileName, String bucketName) {
        return "/file/download/" + fileName + "?bucketName=" + bucketName;
    }
}
