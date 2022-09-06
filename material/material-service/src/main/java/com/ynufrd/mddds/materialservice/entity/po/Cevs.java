package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 中国情绪影像材料库（CEVS）
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
public class Cevs extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 片段电影名
     */
    private String title;

    /**
     * 情绪(愤怒、恐惧、悲伤、厌恶、快乐、中性)
     */
    private String emotion;

    /**
     * 谓离散性，是指该影像片段所诱发的目标情绪的纯度(5个等级)。
     */
    private Integer discreteness;

    /**
     * 强度，是指该影像片段所诱发的情绪的剧烈程度(5个等级)
     */
    private Integer strength;

    /**
     * 正性0，中性1，负性2
     */
    private Integer property;

    /**
     * 因子1 为“纠结”，包括内疚，痛苦和害羞；因子 2 为“惊恐”，包括恐惧和惊奇；因子 3 为“拒绝”，包括轻蔑和愤怒；因子 4 为“愉快”,单个视频因子不唯一
     */
    private String factor;

    /**
     * 片段描述
     */
    private String description;

    /**
     * 视频持续时间，单位s
     */
    private Integer duration;

    /**
     * 片段开头描述
     */
    private String frameFirst;

    /**
     * 片段结尾描述
     */
    private String frameLast;

    /**
     * 预览地址
     */
    private String urlPreview;

    /**
     * 下载地址
     */
    private String urlDownload;

    /**
     * 储存桶名
     */
    private String bucketName;




}
