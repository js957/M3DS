package com.ynufrd.mddds.materialservice.service.impl;

import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.entity.po.TemplateExperimental;
import com.ynufrd.mddds.materialservice.entity.vo.MaterialVo;
import com.ynufrd.mddds.materialservice.entity.vo.TemplateExperimentalVo;
import com.ynufrd.mddds.materialservice.mapper.TemplateExperimentalMapper;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import com.ynufrd.mddds.materialservice.service.ITemplateExperimentalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单个实验 服务实现类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@Service
public class TemplateExperimentalServiceImpl extends ServiceImpl<TemplateExperimentalMapper, TemplateExperimental> implements ITemplateExperimentalService {

    @Autowired
    IMaterialService materialServiceImpl;

    @Override
    public TemplateExperimentalVo get(String id) {
        TemplateExperimental templateExperimental = this.getById(id);
        MaterialVo materialVo = materialServiceImpl.get(templateExperimental.getMaterialId());
        TemplateExperimentalVo templateExperimentalVo = new TemplateExperimentalVo(templateExperimental);
        templateExperimentalVo.setMaterial(materialVo);
        return templateExperimentalVo;
    }
}
