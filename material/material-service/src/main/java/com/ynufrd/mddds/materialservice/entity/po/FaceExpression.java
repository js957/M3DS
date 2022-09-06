package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjs
 * @since 2022-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaceExpression extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 面部图片名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄段(o=老人，y=年轻人，m=中年人)
     */
    private String age;

    /**
     * 情绪(a=生气，d=焦虑，f=害怕，h=开心,n=自然，s=伤心)
     */
    private String emotion;

        /**
     * 图片浏览地址
     */
    private String urlPreview;

    /**
     * 图片下载地址
     */
    private String urlDownload;

    /**
     * 存储桶
     */
    private String bucketName;



}
