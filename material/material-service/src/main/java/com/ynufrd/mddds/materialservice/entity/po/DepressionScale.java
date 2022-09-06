package com.ynufrd.mddds.materialservice.entity.po;


import java.util.List;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.ynufrd.mddds.common.web.entity.po.BasePo;
import com.ynufrd.mddds.materialservice.handler.JSONTypeHandler;
import com.ynufrd.mddds.materialservice.handler.ListToStringHandler;

import com.ynufrd.mddds.materialservice.handler.ObjectAndJsonHandler;
import lombok.*;
import lombok.experimental.Accessors;



/**
 * <p>
 * 量表
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
@TableName(autoResultMap = true)
public class DepressionScale extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 来源如(HAMD)
     */

    private String source;

    /**
     * 完整问题
     */

    private String question;

    /**
     * 选项以及分数以json格式字符串存储
     */

    @TableField(typeHandler= ObjectAndJsonHandler.class)
    private List<Option> optioned;


}
