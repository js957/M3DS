package com.ynufrd.mddds.materialservice.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.common.web.entity.param.BaseParam;
import com.ynufrd.mddds.materialservice.entity.po.Caps;
import lombok.Data;

/**
 * Created by wjs on 2022/08/18
 */
@Data
public class CapsQueryParam extends BaseParam<Caps> {
    private String name;
    private Double valence;
    private Double stdV;
    private Double arousal;
    private Double stdA;
    private Double dominance;
    private Double stdD;

    @Override
    public QueryWrapper<Caps> build() {
        QueryWrapper<Caps> queryWrapper = super.build();
        queryWrapper.like(null != this.name, "name", this.name);
        // 还没写完
        return queryWrapper;
    }
}
