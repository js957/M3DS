package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.Cevs;
import com.ynufrd.mddds.materialservice.entity.po.FaceExpression;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2022/08/20
 */
@ApiModel
@Data
public class FaceExpressionForm extends BaseForm<FaceExpression> {

    /**
     * 面部图片名
     */
    @NotBlank(message = "面部图片名不能为空")
    @ApiModelProperty(value = "面部图片名")
    private String name;

    /**
     * 面部图片文件
     */
    @NotNull(message = "面部图片文件不能为空")
    @ApiModelProperty(value = "面部图片文件")
    private MultipartFile file;
}
