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
public class UserInfo extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;


    /**
     * 性别(1=男，0=女)
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 是否抑郁症
     */
    private Boolean depression;

    /**
     * 抑郁等级
     */
    private Integer depressionLevel;

    /**
     * 量表分数
     */
    private Integer depressionScore;




}
