package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 一套实验
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
public class TemplateProcedure extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 实验名(如：抑郁症实验模板1)
     */
    private String proName;



}
