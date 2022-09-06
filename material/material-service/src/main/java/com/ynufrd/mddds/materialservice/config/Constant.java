package com.ynufrd.mddds.materialservice.config;

/**
 * Created by wjs on 2022/08/20
 */
public class Constant {
    //public static final String MATERIAL_BUCKET_NAME = "material";
    public static final String MATERIAL_CAPS = "caps";
    public static final String MATERIAL_CAWS = "caws";
    public static final String MATERIAL_CEVS = "cevs";
    public static final String MATERIAL_DEPRESSION_SCALE = "depression-scale";
    public static final String MATERIAL_FACE_EXPRESSION = "face-expression";
    public static final String MATERIAL_VOICE_PROMPT_MATERIAL = "voice-prompt-material";
    public static final String MATERIAL_TYPE_WORD = "word";
    public static final String MATERIAL_TYPE_TEXT = "text";
    public static final String MATERIAL_TYPE_QUESTION = "question";
    public static final String MATERIAL_TYPE_VIDEO = "video";
    public static final String MATERIAL_TYPE_AUDIO = "audio";
    public static final String MATERIAL_TYPE_PICTURE = "picture";

    public static String getPreviewUri(String fileName, String bucketName) {
        return "/file/preview/" + fileName + "?bucketName=" + bucketName;
    }

    public static String getDownloadUri(String fileName, String bucketName) {
        return "/file/download/" + fileName + "?bucketName=" + bucketName;
    }
}
