package com.ynufrd.mddds.common.web.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasePo implements Serializable {
    public final static String DEFAULT_USERNAME = "system";
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic
    private Boolean deleted;
}
