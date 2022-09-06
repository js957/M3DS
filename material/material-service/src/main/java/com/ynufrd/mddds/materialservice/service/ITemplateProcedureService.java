package com.ynufrd.mddds.materialservice.service;

import com.ynufrd.mddds.materialservice.entity.po.TemplateProcedure;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ynufrd.mddds.materialservice.entity.vo.TemplateProcedureVo;

/**
 * <p>
 * 一套实验 服务类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
public interface ITemplateProcedureService extends IService<TemplateProcedure> {

    /**
    * 获取TemplateProcedureVo用于显示
    */
    public TemplateProcedureVo get(String id);
}
