package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.TemplateProcedure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class TemplateProcedureForm extends BaseForm<TemplateProcedure> {

    /**
     * 实验模板名(如：抑郁症实验模板1)
     */
    @NotBlank(message = "实验模板名不能为空")
    @ApiModelProperty(value = "实验名")
    private String proName;
}
