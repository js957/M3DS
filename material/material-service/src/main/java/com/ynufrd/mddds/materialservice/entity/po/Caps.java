package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 中国情感图片系统（CAPS）
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Caps extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 图片名
     */
    private String name;

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

    /**
     * 愉悦度均值
     */
    private Double valence;

    /**
     * 愉悦度标准差
     */
    private Double stdV;

    /**
     * 唤醒度均值
     */
    private Double arousal;

    /**
     * 唤醒度标准差
     */
    private Double stdA;

    /**
     * 优势度均值
     */
    private Double dominance;

    /**
     * 优势度标准差
     */
    private Double stdD;




}
