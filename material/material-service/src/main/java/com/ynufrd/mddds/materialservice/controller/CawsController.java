package com.ynufrd.mddds.materialservice.controller;


import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.config.Constant;
import com.ynufrd.mddds.materialservice.entity.form.CapsForm;
import com.ynufrd.mddds.materialservice.entity.form.CapsQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.CawsForm;
import com.ynufrd.mddds.materialservice.entity.form.CawsQueryForm;
import com.ynufrd.mddds.materialservice.entity.po.Caws;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.service.ICawsService;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 现代汉语情感词系统（CAWS） 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/caws")
@Api("caws")
@Slf4j
public class CawsController {

    @Autowired
    ICawsService cawsServiceImpl;

    @Autowired
    IMaterialService materialServiceImpl;

    @ApiOperation(value = "新增Caws材料", notes = "新增Caws材料")
    @ApiImplicitParam(name = "cawsForm", value = "新增Caws表单", required = true, dataType = "CawsForm")
    @PostMapping
    public Result add(@Valid CawsForm cawsForm){
        Caws caws = cawsForm.toPo(Caws.class);
        cawsServiceImpl.saveOrUpdate(caws);
        Material material = new Material(Constant.MATERIAL_CAWS,Constant.MATERIAL_TYPE_WORD,caws.getId(),caws.getWord());
        return Result.success(materialServiceImpl.save(material));
    }

    @ApiOperation(value = "删除Caws材料", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "Caws材料ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id){
        return Result.success();
    }

    @ApiOperation(value = "修改Caws材料", notes = "修改指定Caws材料信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Caws材料ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "cawsForm", value = "用户组实体", required = true, dataType = "CawsForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody CawsForm cawsForm) {
        return Result.success();
    }

    @ApiOperation(value = "获取Caws材料", notes = "获取指定Caws材料信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "Caws材料ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success();
    }

    @ApiOperation(value = "查询Caws材料", notes = "根据条件查询Caws材料信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "Caws材料名称", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping
    public Result query(@RequestParam String name) {
        return Result.success();
    }

    @ApiOperation(value = "搜索Caws材料", notes = "根据条件查询Caws材料信息")
    @ApiImplicitParam(name = "cawsQueryForm", value = "Caws材料查询参数", required = true, dataType = "CawsQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody CawsQueryForm cawsQueryForm) {
        return Result.success();
    }
}
