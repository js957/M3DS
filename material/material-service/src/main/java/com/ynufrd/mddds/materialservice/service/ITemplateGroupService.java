package com.ynufrd.mddds.materialservice.service;

import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ynufrd.mddds.materialservice.entity.vo.TemplateGroupVo;
import com.ynufrd.mddds.materialservice.entity.vo.TemplateProcedureVo;

/**
 * <p>
 * 一组实验 服务类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
public interface ITemplateGroupService extends IService<TemplateGroup> {

    /**
     * 获取TemplateGroupVo用于显示
     */
    public TemplateGroupVo get(String id);
}
