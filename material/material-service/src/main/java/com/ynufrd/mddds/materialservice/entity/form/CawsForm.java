package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.Caps;
import com.ynufrd.mddds.materialservice.entity.po.Caws;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class CawsForm extends BaseForm<Caws> {
    /**
     * 单词
     */
    @NotBlank(message = "单词不能为空")
    @ApiModelProperty(value = "单词")
    private String word;

    /**
     * 词性
     */
    @NotBlank(message = "词性不能为空")
    @ApiModelProperty(value = "词性")
    private String partOfSpeech;

    /**
     * 愉悦度均值
     */
    @NotNull(message = "愉悦度均值不能为空")
    @ApiModelProperty(value = "愉悦度均值")
    private Double valence;

    /**
     * 愉悦度标准差
     */
    @NotNull(message = "愉悦度标准差不能为空")
    @ApiModelProperty(value = "愉悦度标准差")
    private Double stdV;

    /**
     * 唤醒度均值
     */
    @NotNull(message = "唤醒度均值不能为空")
    @ApiModelProperty(value = "唤醒度均值")
    private Double arousal;

    /**
     * 唤醒度标准差
     */
    @NotNull(message = "唤醒度标准差不能为空")
    @ApiModelProperty(value = "唤醒度标准差")
    private Double stdA;

    /**
     * 优势度均值
     */
    @NotNull(message = "优势度均值不能为空")
    @ApiModelProperty(value = "优势度均值")
    private Double dominance;

    /**
     * 优势度标准差
     */
    @NotNull(message = "优势度标准差不能为空")
    @ApiModelProperty(value = "优势度标准差")
    private Double stdD;

    /**
     * 首字笔画
     */
    @ApiModelProperty(value = "首字笔画")
    private Integer strokesF;

    /**
     * 尾字笔画
     */
    @ApiModelProperty(value = "尾字笔画")
    private Integer strokesL;

    /**
     * 词频
     */
    @ApiModelProperty(value = "词频")
    private Double frequency;

    /**
     * 首字频
     */
    @ApiModelProperty(value = "首字频")
    private Double frequencyF;

    /**
     * 尾字频
     */
    @ApiModelProperty(value = "尾字频")
    private Double frequencyL;
}
