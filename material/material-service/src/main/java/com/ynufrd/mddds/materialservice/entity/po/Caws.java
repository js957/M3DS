package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 现代汉语情感词系统（CAWS）
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
public class Caws extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 单词
     */
    private String word;

    /**
     * 词性
     */
    private String partOfSpeech;

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

    /**
     * 首字笔画
     */
    private Integer strokesF;

    /**
     * 尾字笔画
     */
    private Integer strokesL;

    /**
     * 词频
     */
    private Double frequency;

    /**
     * 首字频
     */
    private Double frequencyF;

    /**
     * 尾字频
     */
    private Double frequencyL;



}
