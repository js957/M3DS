package com.ynufrd.mddds.materialservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import com.ynufrd.mddds.materialservice.entity.po.TemplateProcedure;
import com.ynufrd.mddds.materialservice.entity.vo.TemplateProcedureVo;
import com.ynufrd.mddds.materialservice.mapper.TemplateProcedureMapper;
import com.ynufrd.mddds.materialservice.service.ITemplateGroupService;
import com.ynufrd.mddds.materialservice.service.ITemplateProcedureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 一套实验 服务实现类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@Service
public class TemplateProcedureServiceImpl extends ServiceImpl<TemplateProcedureMapper, TemplateProcedure> implements ITemplateProcedureService {

    @Autowired
    private ITemplateGroupService templateGroupServiceImpl;
    @Override
    public TemplateProcedureVo get(String id) {
        QueryWrapper<TemplateGroup> templateGroupQueryWrapper = new QueryWrapper<>();
        templateGroupQueryWrapper.eq("temp_proce_id",id);
        templateGroupQueryWrapper.orderByAsc("sequence","id");
        List<TemplateGroup> templateGroups = templateGroupServiceImpl.list(templateGroupQueryWrapper);
        TemplateProcedure templateProcedure = this.getById(id);
        TemplateProcedureVo templateProcedureVo = new TemplateProcedureVo(templateProcedure,templateGroups);
        return templateProcedureVo;
    }
}
