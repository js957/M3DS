package com.ynufrd.mddds.collectionservice.entity.form;

import com.ynufrd.mddds.collectionservice.entity.po.AnswerQuestion;
import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by wjs on 2022/08/22
 */
@ApiModel
@Data
public class AnswerQuestionForm extends BaseForm<AnswerQuestion> {

    /**
     * 回答人ID
     */
    @NotBlank(message = "回答人ID不能为空")
    @ApiModelProperty(value = "回答人ID")
    private String userId;


    /**
     * 选择的答案
     */
    @NotBlank(message = "选择的答案不能为空")
    @ApiModelProperty(value = "选择的答案")
    private String selected;

    /**
     * 得分
     */
    @ApiModelProperty(value = "得分")
    private Integer score;


    /**
     * 哪个实验
     */
    @NotBlank(message = "实验ID不能为空")
    @ApiModelProperty(value = "实验ID")
    private String tempExpId;
}
