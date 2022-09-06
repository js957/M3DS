package com.ynufrd.mddds.collectionservice.entity.form;

import com.ynufrd.mddds.collectionservice.entity.po.VideoInfo;
import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2022/08/22
 */
@ApiModel
@Data
public class VideoInfoForm extends BaseForm<VideoInfo> {

    /**
     * 采集的用户
     */
    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 哪个实验
     */
    @NotNull(message = "实验id不能为空")
    @ApiModelProperty(value = "实验id")
    private String tempExpId;
    /**
     * 上传的视频文件
     */
    @NotNull(message = "上传的视频文件不能为空")
    @ApiModelProperty(value = "上传的视频文件")
    private MultipartFile file;
}
