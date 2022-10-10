package com.ynufrd.mddds.materialservice.controller;


import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.entity.form.CapsForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateGroupQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateProcedureForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateProcedureQueryForm;
import com.ynufrd.mddds.materialservice.entity.param.TemplateProcedureQueryParam;
import com.ynufrd.mddds.materialservice.entity.po.TemplateProcedure;
import com.ynufrd.mddds.materialservice.service.ITemplateProcedureService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 一套实验 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/templateProcedure")
@Api("templateProcedure")
@Slf4j
public class TemplateProcedureController {


    @Autowired
    ITemplateProcedureService templateProcedureService;

    @ApiOperation(value = "新增实验模板", notes = "新增实验模板")
    @ApiImplicitParam(name = "templateProcedureForm", value = "新增实验模板", required = true, dataType = "TemplateProcedureForm")
    @PostMapping
    public Result add(@Valid TemplateProcedureForm templateProcedureForm) {
        return Result.success(templateProcedureService.save(templateProcedureForm.toPo(TemplateProcedure.class)));
    }

    @ApiOperation(value = "删除实验模板", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "实验模板 ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success(templateProcedureService.removeById(id));
    }

    @ApiOperation(value = "修改实验模板", notes = "修改指定实验模板信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Caps材料ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "templateProcedureForm", value = "实验模板", required = true, dataType = "TemplateProcedureForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody TemplateProcedureForm templateProcedureForm) {
        TemplateProcedure templateProcedure = templateProcedureForm.toPo(TemplateProcedure.class);
        templateProcedure.setId(id);
        return Result.success(templateProcedureService.saveOrUpdate(templateProcedure));
    }

    @ApiOperation(value = "获取实验模板", notes = "获取指定实验模板信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "实验模板ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(templateProcedureService.get(id));
    }


    @ApiOperation(value = "搜索实验模板", notes = "根据条件查询实验模板")
    @ApiImplicitParam(name = "templateProcedureQueryForm", value = "实验模板查询参数", required = true, dataType = "TemplateProcedureQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody TemplateProcedureQueryForm templateProcedureQueryForm) {
        /**
        *@Param: [templateProcedureQueryForm]
        *@Author: wjs
        *@date: 21:41
         * proName,createdTimeStart,createdTimeEnd,current,size
        */
        Page<TemplateProcedure> page = templateProcedureQueryForm.getPage();
        TemplateProcedureQueryParam param = templateProcedureQueryForm.toParam(TemplateProcedureQueryParam.class);
        return Result.success(templateProcedureService.page(page,param.build()));
    }

}
