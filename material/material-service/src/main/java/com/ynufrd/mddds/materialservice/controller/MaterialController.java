package com.ynufrd.mddds.materialservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.entity.form.CevsForm;
import com.ynufrd.mddds.materialservice.entity.form.CevsQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.MaterialQueryForm;
import com.ynufrd.mddds.materialservice.entity.param.MaterialQueryParam;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 材料库 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/material")
@Api("material")
@Slf4j
public class MaterialController {

    @Autowired
    IMaterialService materialServiceImpl;

    @ApiOperation(value = "删除材料", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "材料ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success();
    }


    @ApiOperation(value = "获取材料", notes = "获取指定材料信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "材料ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(materialServiceImpl.get(id));
    }


    @ApiOperation(value = "搜索材料", notes = "根据条件查询材料信息")
    @ApiImplicitParam(name = "materialQueryForm", value = "材料查询参数", required = true, dataType = "MaterialQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody MaterialQueryForm materialQueryForm) {return Result.success();}
}
