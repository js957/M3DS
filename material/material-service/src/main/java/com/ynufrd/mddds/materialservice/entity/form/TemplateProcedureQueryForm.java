package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseQueryForm;
import com.ynufrd.mddds.materialservice.entity.param.TemplateProcedureQueryParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class TemplateProcedureQueryForm extends BaseQueryForm<TemplateProcedureQueryParam> {
    private String proName;
    private Date createdTimeStart;
    private Date createdTimeEnd;


}
