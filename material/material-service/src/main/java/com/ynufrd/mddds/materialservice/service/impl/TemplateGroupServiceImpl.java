package com.ynufrd.mddds.materialservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.entity.po.TemplateExperimental;
import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import com.ynufrd.mddds.materialservice.entity.vo.TemplateGroupVo;
import com.ynufrd.mddds.materialservice.mapper.TemplateGroupMapper;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import com.ynufrd.mddds.materialservice.service.ITemplateExperimentalService;
import com.ynufrd.mddds.materialservice.service.ITemplateGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 一组实验 服务实现类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@Service
public class TemplateGroupServiceImpl extends ServiceImpl<TemplateGroupMapper, TemplateGroup> implements ITemplateGroupService {

    @Autowired
    ITemplateExperimentalService templateExperimentalServiceImpl;

    @Autowired
    IMaterialService materialServiceImpl;

    /**
    *@Param:
    *@Author: wjs
    *@date: 13:43
     * 获取实验组信息集包含的每个小实验
    */
    @Override
    public TemplateGroupVo get(String id) {
        List<TemplateExperimental> templateExperimentalList = templateExperimentalServiceImpl.list(
                new QueryWrapper<TemplateExperimental>()
                        .eq("temp_group_id",id)
                        .orderByAsc("sequence","created_time"));
        TemplateGroup templateGroup = this.getById(id);
        TemplateGroupVo templateGroupVo = new TemplateGroupVo(templateGroup);
        templateGroupVo.setExperimentalList(templateExperimentalList.stream().map(TemplateExperimental::getId).collect(Collectors.toList()));
        return templateGroupVo;
    }
}
