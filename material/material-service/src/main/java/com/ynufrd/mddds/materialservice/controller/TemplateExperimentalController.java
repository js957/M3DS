package com.ynufrd.mddds.materialservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.entity.form.TemplateExperimentalForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateExperimentalQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateGroupForm;
import com.ynufrd.mddds.materialservice.entity.form.TemplateGroupQueryForm;
import com.ynufrd.mddds.materialservice.entity.po.TemplateExperimental;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import com.ynufrd.mddds.materialservice.service.ITemplateExperimentalService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 单个实验 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/templateExperimental")
@Api("templateExperimental")
@Slf4j
public class TemplateExperimentalController {

    @Autowired
    ITemplateExperimentalService templateExperimentalServiceImpl;

    @Autowired
    IMaterialService materialServiceImpl;

    @ApiOperation(value = "新增一个实验", notes = "新增一个实验")
    @ApiImplicitParam(name = "templateExperimentalForm", value = "新增一组实验表单", required = true, dataType = "TemplateExperimentalForm")
    @PostMapping
    public Result add(@Valid TemplateExperimentalForm templateExperimentalForm) {
        TemplateExperimental templateExperimental = templateExperimentalForm.toPo(TemplateExperimental.class);
        TemplateExperimental lastExperimental = templateExperimentalServiceImpl.getOne(
                new QueryWrapper<TemplateExperimental>()
                        .eq("temp_group_id", templateExperimental.getTempGroupId())
                        .orderByDesc("sequence","created_time")
                        .last("limit 1"));
        if(lastExperimental == null){
            templateExperimental.setSequence(1);
        }else {
            templateExperimental.setSequence(lastExperimental.getSequence() + 1);
        }
        return Result.success(templateExperimentalServiceImpl.save(templateExperimental));
    }

    @ApiOperation(value = "删除一个实验", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "实验 ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success(templateExperimentalServiceImpl.removeById(id));
    }

    @ApiOperation(value = "修改实验信息", notes = "修改指定实验信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "实验ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "templateExperimentalForm", value = "实验实体", required = true, dataType = "TemplateExperimentalForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody TemplateExperimentalForm templateExperimentalForm) {
        TemplateExperimental templateExperimental = templateExperimentalForm.toPo(TemplateExperimental.class);
        templateExperimental.setId(id);
        return Result.success(templateExperimentalServiceImpl.saveOrUpdate(templateExperimental));
    }

    @ApiOperation(value = "获取实验", notes = "获取指定实验信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "实验ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(templateExperimentalServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索实验组", notes = "根据条件查询实验组")
    @ApiImplicitParam(name = "templateExperimentalQueryForm", value = "实验查询参数", required = true, dataType = "TemplateExperimentalQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody TemplateExperimentalQueryForm templateExperimentalQueryForm) {
        return Result.success();
    }
}
