package com.ynufrd.mddds.materialservice.service;

import com.ynufrd.mddds.materialservice.entity.po.TemplateExperimental;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ynufrd.mddds.materialservice.entity.vo.TemplateExperimentalVo;

/**
 * <p>
 * 单个实验 服务类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
public interface ITemplateExperimentalService extends IService<TemplateExperimental> {

    public TemplateExperimentalVo get(String id);
}
