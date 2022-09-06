package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.TemplateExperimental;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class TemplateExperimentalForm extends BaseForm<TemplateExperimental> {
    /**
     * 实验持续时间(单位s，0为时间不限)
     */
    @ApiModelProperty(value = "实验持续时间")
    private Integer duration;

    /**
     * 实验名
     */
    @NotBlank(message = "实验名不能为空")
    @ApiModelProperty(value = "实验名")
    private String expName;

    /**
     * 材料id
     */
    @NotBlank(message = "材料id不能为空")
    @ApiModelProperty(value = "材料id")
    private String materialId;

    /**
     * 实验前文本提示
     */
    @ApiModelProperty(value = "菜单父id")
    private String tipsBfExpText;


    /**
     * 实验后文本提示
     */
    @ApiModelProperty(value = "菜单父id")
    private String tipsAfExpText;


    /**
     * 所属的组
     */
    @NotBlank(message = "菜单父id不能为空")
    @ApiModelProperty(value = "菜单父id")
    private String tempGroupId;
}
