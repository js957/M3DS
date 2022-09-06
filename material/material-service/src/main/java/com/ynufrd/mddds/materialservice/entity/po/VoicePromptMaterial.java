package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 语音提示材料表
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoicePromptMaterial extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 实验开始前的引导0、实验结束后的询问1
     */
    private Integer type;

    /**
     * 语音的文本信息
     */
    private String textMessage;

    /**
     * 语音流地址
     */
    private String urlPreview;

    /**
     * 语音下载地址
     */
    private String urlDownload;

    /**
     * 数据桶名
     */
    private String bucketName;




}
