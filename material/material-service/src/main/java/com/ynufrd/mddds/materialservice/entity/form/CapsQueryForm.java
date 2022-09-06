package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseQueryForm;
import com.ynufrd.mddds.materialservice.entity.param.CapsQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

/**
 * Created by wjs on 2022/08/18
 */
@ApiModel
@Data
public class CapsQueryForm extends BaseQueryForm<CapsQueryParam> {

    /**
     * 图片名
     */
    @ApiModelProperty(value = "图片名")
    private String name;

    /**
     * 愉悦度均值
     */
    @ApiModelProperty(value = "愉悦度均值")
    private Double valence;

    /**
     * 愉悦度标准差
     */
    @ApiModelProperty(value = "愉悦度标准差")
    private Double stdV;

    /**
     * 唤醒度均值
     */
    @ApiModelProperty(value = "唤醒度均值")
    private Double arousal;

    /**
     * 唤醒度标准差
     */
    @ApiModelProperty(value = "唤醒度标准差")
    private Double stdA;

    /**
     * 优势度均值
     */
    @ApiModelProperty(value = "优势度均值")
    private Double dominance;

    /**
     * 优势度标准差
     */
    @ApiModelProperty(value = "优势度标准差")
    private Double stdD;
}
