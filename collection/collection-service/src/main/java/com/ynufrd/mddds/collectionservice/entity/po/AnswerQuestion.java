package com.ynufrd.mddds.collectionservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjs
 * @since 2022-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerQuestion extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 回答人
     */
    private String userId;


    /**
     * 选择的答案
     */
    private String selected;

    /**
     * 得分
     */
    private Integer score;


    /**
     * 哪个实验
     */
    private String tempExpId;



}
