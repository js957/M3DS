package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseForm;
import com.ynufrd.mddds.materialservice.entity.po.Cevs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import zipkin2.Call;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class CevsForm extends BaseForm<Cevs> {

    /**
     * 片段电影名
     */
    @NotBlank(message = "片段电影名不能为空")
    @ApiModelProperty(value = "片段电影名")
    private String title;

    /**
     * 情绪(愤怒、恐惧、悲伤、厌恶、快乐、中性)
     */
    @NotBlank(message = "片段激发情绪不能为空")
    @ApiModelProperty(value = "情绪(愤怒、恐惧、悲伤、厌恶、快乐、中性)")
    private String emotion;

    /**
     * 离散性，是指该影像片段所诱发的目标情绪的纯度(5个等级)。
     */
    @NotNull(message = "离散性不能为空")
    @ApiModelProperty(value = "离散性")
    private Integer discreteness;

    /**
     * 强度，是指该影像片段所诱发的情绪的剧烈程度(5个等级)
     */
    @NotNull(message = "强度不能为空")
    @ApiModelProperty(value = "强度")
    private Integer strength;

    /**
     * 正性0，中性1，负性2
     */
    @ApiModelProperty(value = "性质")
    private Integer property;

    /**
     * 因子1 为“纠结”，包括内疚，痛苦和害羞；因子 2 为“惊恐”，包括恐惧和惊奇；因子 3 为“拒绝”，包括轻蔑和愤怒；因子 4 为“愉快”,单个视频因子不唯一
     */
    @ApiModelProperty(value = "因子")
    private String factor;

    /**
     * 片段描述
     */
    @ApiModelProperty(value = "片段描述")
    private String description;

    /**
     * 持续时间s
     */
    @ApiModelProperty(value = "持续时间s")
    private Integer duration;
    /**
     * 片段开头描述
     */
    @ApiModelProperty(value = "片段开头描述")
    private String frameFirst;

    /**
     * 片段结尾描述
     */
    @ApiModelProperty(value = "片段结尾描述")
    private String frameLast;

      /**
     * cevs材料文件
     */
    @NotNull(message = "cevs材料文件不能为空")
    @ApiModelProperty(value = "cevs材料文件")
    private MultipartFile file;
}
