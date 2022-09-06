package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 单个实验
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
public class TemplateExperimental extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 实验持续时间(单位s，0为时间不限)
     */
    private Integer duration;

    /**
     * 实验名
     */
    private String expName;

        /**
     * 实验类型
     */
    private String type;

    /**
     * 材料id
     */
    private String materialId;

    /**
     * 实验前文本提示
     */
    private String tipsBfExpText;

    /**
     * 实验前语音提示
     */
    private String tipsBfExpPreview;

    /**
     * 实验后文本提示
     */
    private String tipsAfExpText;

    /**
     * 实验后语音提示
     */
    private String tipsAfExpPreview;

    /**
     * 所属的组
     */
    private String tempGroupId;

    /**
    * 顺序
    */
    private Integer sequence;




}
