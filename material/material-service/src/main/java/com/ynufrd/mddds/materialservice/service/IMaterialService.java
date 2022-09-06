package com.ynufrd.mddds.materialservice.service;

import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ynufrd.mddds.materialservice.entity.vo.MaterialVo;

/**
 * <p>
 * 材料库 服务类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
public interface IMaterialService extends IService<Material> {

    public MaterialVo get(String id);
}
