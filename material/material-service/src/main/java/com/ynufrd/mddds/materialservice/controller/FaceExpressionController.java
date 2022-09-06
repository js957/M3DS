package com.ynufrd.mddds.materialservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.materialservice.config.Constant;
import com.ynufrd.mddds.materialservice.entity.form.CapsForm;
import com.ynufrd.mddds.materialservice.entity.form.CapsQueryForm;
import com.ynufrd.mddds.materialservice.entity.form.FaceExpressionForm;
import com.ynufrd.mddds.materialservice.entity.po.Caps;
import com.ynufrd.mddds.materialservice.entity.po.FaceExpression;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.provider.FileServiceProvider;
import com.ynufrd.mddds.materialservice.service.ICapsService;
import com.ynufrd.mddds.materialservice.service.IFaceExpressionService;
import com.ynufrd.mddds.materialservice.service.IMaterialService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-20
 */
@RestController
@RequestMapping("/materialservice/faceExpression")
@Api("faceExpression")
@Slf4j
public class FaceExpressionController {

    @Autowired
    private IFaceExpressionService faceExpressionServiceImpl;

    @Autowired
    private FileServiceProvider fileServiceProvider;

    @Autowired
    private IMaterialService materialServiceImpl;

    @ApiOperation(value = "新增人脸图片材料", notes = "新增人脸图片材料")
    @ApiImplicitParam(name = "faceExpressionForm", value = "新增人脸图片材料表单", required = true, dataType = "FaceExpressionForm")
    @PostMapping
    public Result add(@Valid FaceExpressionForm faceExpressionForm) {
        Result<String> result = fileServiceProvider.upload(faceExpressionForm.getFile(), Constant.MATERIAL_FACE_EXPRESSION);
        FaceExpression faceExpression = faceExpressionForm.toPo(FaceExpression.class);
        faceExpression.setUrlPreview(Constant.getPreviewUri(result.getData().toString(),Constant.MATERIAL_FACE_EXPRESSION));
        faceExpression.setUrlDownload(Constant.getDownloadUri(result.getData().toString(), Constant.MATERIAL_FACE_EXPRESSION));
        faceExpression.setBucketName(Constant.MATERIAL_FACE_EXPRESSION);
        // 图片名为004_o_m_a_a
        // 004为编码无意义，o为年龄段,m为性别,a为情绪,最后一个a表示两张生气的图片的其中一张
        String[] faceExpressionInfo = faceExpressionForm.getName().split("_");
        faceExpression.setAge(faceExpressionInfo[1]);
        faceExpression.setSex(faceExpressionInfo[2]);
        faceExpression.setEmotion(faceExpressionInfo[3]);
        faceExpressionServiceImpl.saveOrUpdate(faceExpression);
        Material material = new Material(Constant.MATERIAL_FACE_EXPRESSION,
                Constant.MATERIAL_TYPE_PICTURE,
                faceExpression.getId(),
                faceExpression.getUrlPreview());
        return Result.success(materialServiceImpl.save(material));
    }


}
