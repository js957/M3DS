package com.ynufrd.mddds.materialservice.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.config.Constant;
import com.ynufrd.mddds.materialservice.entity.form.CevsForm;
import com.ynufrd.mddds.materialservice.entity.form.CevsQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.DepressionScaleForm;
import com.ynufrd.mddds.materialservice.entity.po.DepressionScale;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.service.IDepressionScaleService;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * <p>
 * 量表 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/materialservice/depressionScale")
@Api("depressionScale")
@Slf4j
public class DepressionScaleController {

    @Autowired
    IDepressionScaleService depressionScaleServiceImpl;

    @Autowired
    IMaterialService materialServiceImpl;

    @ApiOperation(value = "新增问题", notes = "新增问题")
    @ApiImplicitParam(name = "depressionScaleForm", value = "新增问题表单", required = true, dataType = "DepressionScaleForm")
    @PostMapping
    public Result add(@Valid @RequestBody DepressionScaleForm depressionScaleForm) {
        DepressionScale depressionScale = depressionScaleForm.toPo(DepressionScale.class);
        //depressionScale.setOption(JSONArray.toJSONString(depressionScaleForm.getOption()));
        depressionScaleServiceImpl.save(depressionScale);
        HashMap<String, String> questionMap = new HashMap<String,String>();
        questionMap.put("question",depressionScale.getQuestion());
        questionMap.put("optioned",JSONArray.toJSONString(depressionScale.getOptioned()));
        Material material = new Material(Constant.MATERIAL_DEPRESSION_SCALE,
                Constant.MATERIAL_TYPE_QUESTION,
                depressionScale.getId(),
                JSON.toJSONString(questionMap));
        return Result.success(materialServiceImpl.save(material));
    }

    @ApiOperation(value = "删除问题", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "DepressionScale ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success();
    }

    @ApiOperation(value = "修改问题", notes = "修改指定问题信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "DepressionScale ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "depressionScaleForm", value = "问题实体", required = true, dataType = "DepressionScaleForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody DepressionScaleForm depressionScaleForm) {
        return Result.success();
    }

    @ApiOperation(value = "获取DepressionScale问题", notes = "获取指定DepressionScale信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "DepressionScale ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success();
    }



}
