package com.ynufrd.mddds.materialservice.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.common.web.entity.param.BaseParam;
import com.ynufrd.mddds.materialservice.entity.po.TemplateProcedure;
import lombok.Data;

/**
 * Created by wjs on 2022/08/19
 */
@Data
public class TemplateProcedureQueryParam extends BaseParam<TemplateProcedure> {
    private String proName;

    @Override
    public QueryWrapper<TemplateProcedure> build() {
        QueryWrapper<TemplateProcedure> queryWrapper = super.build();
        queryWrapper.like(null!=this.proName,"pro_name",this.proName);
        return queryWrapper;
    }
}
