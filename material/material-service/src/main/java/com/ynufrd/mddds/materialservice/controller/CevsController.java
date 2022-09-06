package com.ynufrd.mddds.materialservice.controller;


import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.config.Constant;
import com.ynufrd.mddds.materialservice.entity.form.CawsForm;
import com.ynufrd.mddds.materialservice.entity.form.CawsQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.CevsForm;
import com.ynufrd.mddds.materialservice.entity.form.CevsQueryForm;
import com.ynufrd.mddds.materialservice.entity.po.Cevs;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.provider.FileServiceProvider;
import com.ynufrd.mddds.materialservice.service.ICevsService;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 中国情绪影像材料库（CEVS） 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/cevs")
@Api("cevs")
@Slf4j
public class CevsController {

    @Autowired
    ICevsService cevsServiceImpl;

    @Autowired
    FileServiceProvider fileServiceProvider;

    @Autowired
    IMaterialService materialServiceImpl;

    @ApiOperation(value = "新增Cevs材料", notes = "新增Cevs材料")
    @ApiImplicitParam(name = "cwvsForm", value = "新增Cevs表单", required = true, dataType = "CevsForm")
    @PostMapping
    public Result add(@Valid CevsForm cevsForm) {
        Cevs cevs = cevsForm.toPo(Cevs.class);
        Result<String> result = fileServiceProvider.upload(cevsForm.getFile(), Constant.MATERIAL_CEVS);
        cevs.setBucketName(Constant.MATERIAL_CEVS);
        cevs.setUrlPreview(Constant.getPreviewUri(result.getData(),Constant.MATERIAL_CEVS));
        cevs.setUrlDownload(Constant.getDownloadUri(result.getData(),Constant.MATERIAL_CEVS));
        cevsServiceImpl.saveOrUpdate(cevs);
        Material material = new Material(Constant.MATERIAL_CEVS,
                Constant.MATERIAL_TYPE_VIDEO,
                cevs.getId(),
                cevs.getUrlPreview());
        return Result.success(materialServiceImpl.save(material));
    }

    @ApiOperation(value = "删除Cevs材料", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "Cevs材料ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success();
    }

    @ApiOperation(value = "修改Cevs材料", notes = "修改指定Cevs材料信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Cevs材料ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "cevsForm", value = "情绪影像类实体", required = true, dataType = "CevsForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody CevsForm cevsForm) {
        return Result.success();
    }

    @ApiOperation(value = "获取Cevs材料", notes = "获取指定Cevs材料信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "Cevs材料ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success();
    }

    @ApiOperation(value = "查询Cevs材料", notes = "根据条件查询Cevs材料信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "Cevs材料名称", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping
    public Result query(@RequestParam String name) {
        return Result.success();
    }

    @ApiOperation(value = "搜索Cevs材料", notes = "根据条件查询Caws材料信息")
    @ApiImplicitParam(name = "cevsQueryForm", value = "Cevs材料查询参数", required = true, dataType = "CevsQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody CevsQueryForm cevsQueryForm) {
        return Result.success();
    }
}
