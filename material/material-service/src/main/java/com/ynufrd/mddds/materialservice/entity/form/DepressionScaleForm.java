package com.ynufrd.mddds.materialservice.entity.form;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.DepressionScale;
import com.ynufrd.mddds.materialservice.entity.po.Option;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class DepressionScaleForm extends BaseForm<DepressionScale> {

    /**
     * 来源如(HAMD)
     */
    @NotBlank(message = "源如不能为空")
    @ApiModelProperty(value = "源如")
    private String source;

    /**
     * 完整问题
     */
    @NotBlank(message = "完整问题不能为空")
    @ApiModelProperty(value = "完整问题")
    private String question;

    /**
     * 选项以及分数以json格式字符串存储
     * {'A,xxx':'4','B,eee':'2'...}
     */
    @NotNull(message = "选项以及分数")
    @ApiModelProperty(value = "选项以及分数")
    private List<Option> optioned;
}
