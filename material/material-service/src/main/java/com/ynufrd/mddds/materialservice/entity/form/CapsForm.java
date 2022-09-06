package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.Caps;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2022/08/18
 */
@ApiModel
@Data
public class CapsForm extends BaseForm<Caps> {

    @NotBlank(message = "图片名不能为空")
    @ApiModelProperty(value = "图片名")
    private String name;
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
     * caps材料文件
     */
    @NotNull(message = "caps材料文件不能为空")
    @ApiModelProperty(value = "caps材料文件")
    private MultipartFile file;
}
