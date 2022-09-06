package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class TemplateGroupForm extends BaseForm<TemplateGroup> {
    /**
     * 一组实验组名
     */
    @NotBlank(message = "实验组名不能为空")
    @ApiModelProperty(value = "实验组名")
    private String groupName;

    /**
     * 实验持续时间
     */
    @ApiModelProperty(value = "实验持续时间")
    private Integer duration;

    /**
     * 一组实验组名
     */
    @NotBlank(message = "实验内容不能为空")
    @ApiModelProperty(value = "实验内容")
    private String content;
    /**
     * 实验最短允许时间
     */
    @ApiModelProperty(value = "实验最短允许时间")
    private Integer durationMin;

    /**
     * 组实验前的文字提示
     */
    @ApiModelProperty(value = "组实验前的文字提示")
    private String tipsBfExpText;

    @ApiModelProperty(value = "组实验后的文字提示")
    private String tipsAfExpText;

    @NotBlank(message = "所属模板不允许为空")
    @ApiModelProperty(value = "所属模板")
    private String tempProceId;
}
