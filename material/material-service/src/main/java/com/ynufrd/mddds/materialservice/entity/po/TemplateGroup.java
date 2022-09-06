package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 一组实验
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
public class TemplateGroup extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 一组实验组名
     */
    private String groupName;

    /**
     * 实验持续时间
     */
    private Integer duration;

    /**
     * 实验最短允许时间
     */
    private Integer durationMin;

    /**
     * 实验内容(text(量表),image(看图),imitate(模仿),video(看视频),read(朗读))
     */
    private String content;
    /**
     * 组实验前的文字提示
     */
    private String tipsBfExpText;

    private String tipsBfExpPreview;
    /**
     * 组实验后的文字提示
     */
    private String tipsAfExpText;

    private String tipsAfExpPreview;

    private String tempProceId;

    private Integer sequence;



}
