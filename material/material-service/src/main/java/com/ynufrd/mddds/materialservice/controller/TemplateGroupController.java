package com.ynufrd.mddds.materialservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.entity.form.CapsForm;
import com.ynufrd.mddds.materialservice.entity.form.CapsQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateGroupForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateGroupQueryForm;
import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import com.ynufrd.mddds.materialservice.service.ITemplateGroupService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 一组实验 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/templateGroup")
@Api("templateGroup")
@Slf4j
public class TemplateGroupController {

    @Autowired
    ITemplateGroupService templateGroupServiceImpl;

    @ApiOperation(value = "新增一组实验", notes = "新增一组实验")
    @ApiImplicitParam(name = "templateGroupForm", value = "新增一组实验表单", required = true, dataType = "TemplateGroupForm")
    @PostMapping
    public Result add(@Valid TemplateGroupForm templateGroupForm){
        TemplateGroup templateGroup = templateGroupForm.toPo(TemplateGroup.class);
        TemplateGroup lastGroup = templateGroupServiceImpl.getOne(
                new QueryWrapper<TemplateGroup>()
                        .eq("temp_proce_id",templateGroup.getTempProceId())
                        .orderByDesc("created_time")
                        .last("limit 1"));
        if(lastGroup == null){
            templateGroup.setSequence(1);
        }else{
            templateGroup.setSequence(lastGroup.getSequence() + 1);
        }

        return Result.success(templateGroupServiceImpl.save(templateGroup));
    }

    @ApiOperation(value = "删除一组实验", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "实验组 ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id){
        return Result.success(templateGroupServiceImpl.removeById(id));
    }

    @ApiOperation(value = "修改实验组信息", notes = "修改指定实验组信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "实验组ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "templateGroupForm", value = "实验组实体", required = true, dataType = "TemplateGroupForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody TemplateGroupForm templateGroupForm) {
        TemplateGroup templateGroup = templateGroupForm.toPo(TemplateGroup.class);
        templateGroup.setId(id);
        return Result.success(templateGroupServiceImpl.saveOrUpdate(templateGroup));
    }

    @ApiOperation(value = "获取实验组", notes = "获取指定实验组信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "实验组ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(templateGroupServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索实验组", notes = "根据条件查询实验组")
    @ApiImplicitParam(name = "templateGroupQueryForm", value = "实验组查询参数", required = true, dataType = "TemplateGroupQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody TemplateGroupQueryForm templateGroupQueryForm) {

        return Result.success();
    }
}
