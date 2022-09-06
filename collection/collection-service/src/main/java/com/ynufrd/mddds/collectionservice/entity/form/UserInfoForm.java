package com.ynufrd.mddds.collectionservice.entity.form;

import com.ynufrd.mddds.collectionservice.entity.po.UserInfo;
import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2022/08/22
 */
@Data
@ApiModel
public class UserInfoForm extends BaseForm<UserInfo> {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String userName;


    /**
     * 性别(1=男，0=女)
     */
    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;
}
