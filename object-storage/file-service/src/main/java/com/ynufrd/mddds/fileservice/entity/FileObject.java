package com.ynufrd.mddds.fileservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by wjs on 2022/08/02
 */
@ApiModel
@Data
public class FileObject {
    @NotBlank(message = "不能为空")
    @ApiModelProperty("文件名")
    private String fileName;
    @NotBlank(message = "不能为空")
    @ApiModelProperty("存储空间(桶)")
    private String bucketName;
}
