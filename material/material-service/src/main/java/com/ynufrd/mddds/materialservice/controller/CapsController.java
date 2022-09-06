package com.ynufrd.mddds.materialservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.config.Constant;
import com.ynufrd.mddds.materialservice.entity.form.CapsForm;
import com.ynufrd.mddds.materialservice.entity.form.CapsQueryForm;
import com.ynufrd.mddds.materialservice.entity.param.CapsQueryParam;
import com.ynufrd.mddds.materialservice.entity.po.Caps;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.provider.FileServiceProvider;
import com.ynufrd.mddds.materialservice.service.ICapsService;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * <p>
 * 中国情感图片系统（CAPS） 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/caps")
@Api("caps")
@Slf4j
public class CapsController {

    @Autowired
    private ICapsService capsServiceImpl;

    @Autowired
    private FileServiceProvider fileServiceProvider;

    @Autowired
    private IMaterialService materialServiceImpl;

    @ApiOperation(value = "新增Caps材料", notes = "新增Caps材料")
    @ApiImplicitParam(name = "capsForm", value = "新增Caps表单", required = true, dataType = "CapsForm")
    @PostMapping
    public Result add(@Valid CapsForm capsForm) {
        Result<String> result = fileServiceProvider.upload(capsForm.getFile(), Constant.MATERIAL_CAPS);
        Caps caps = capsForm.toPo(Caps.class);
        caps.setUrlPreview(Constant.getPreviewUri(result.getData().toString(),Constant.MATERIAL_CAPS));
        caps.setUrlDownload(Constant.getDownloadUri(result.getData().toString(), Constant.MATERIAL_CAPS));
        caps.setBucketName(Constant.MATERIAL_CAPS);
        capsServiceImpl.saveOrUpdate(caps);
        Material material = new Material(Constant.MATERIAL_CAPS,
                Constant.MATERIAL_TYPE_PICTURE,
                caps.getId(),
                caps.getUrlPreview());
        return Result.success(materialServiceImpl.save(material));
    }

    @ApiOperation(value = "删除Caps材料", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "Caps材料ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success(capsServiceImpl.removeById(id));
    }

    @ApiOperation(value = "修改Caps材料", notes = "修改指定Caps材料信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Caps材料ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "capsForm", value = "用户组实体", required = true, dataType = "CapsForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody CapsForm capsForm) {
        Caps caps = capsForm.toPo(Caps.class);
        caps.setId(id);
        return Result.success(capsServiceImpl.updateById(caps));
    }

    @ApiOperation(value = "获取Caps材料", notes = "获取指定Caps材料信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "Caps材料ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(capsServiceImpl.getById(id));
    }

    @ApiOperation(value = "查询Caps材料", notes = "根据条件查询Caps材料信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "Caps材料名称", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping
    public Result query(@RequestParam String name) {
        return Result.success(capsServiceImpl.list(new QueryWrapper<Caps>().like("name",name)));
    }

    @ApiOperation(value = "搜索Caps材料", notes = "根据条件查询Caps材料信息")
    @ApiImplicitParam(name = "capsQueryForm", value = "Caps材料查询参数", required = true, dataType = "CapsQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody CapsQueryForm capsQueryForm) {
        return Result.success();
    }

}
