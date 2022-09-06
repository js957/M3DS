package com.ynufrd.mddds.materialservice.service.impl;

import com.ynufrd.mddds.materialservice.config.Constant;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.entity.vo.MaterialVo;
import com.ynufrd.mddds.materialservice.mapper.MaterialMapper;
import com.ynufrd.mddds.materialservice.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 材料库 服务实现类
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements IMaterialService {

    @Autowired
    ICevsService cevsServiceImpl;

    @Autowired
    ICawsService cawsServiceImpl;

    @Autowired
    ICapsService capsServiceImpl;

    @Autowired
    IDepressionScaleService depressionScaleServiceImpl;

    @Autowired
    IFaceExpressionService faceExpressionServiceImpl;

    @Override
    public MaterialVo get(String id) {
        Material material = this.getById(id);
        MaterialVo materialVo = new MaterialVo(material);
        switch (material.getMaterialName()){
            case Constant.MATERIAL_CEVS : materialVo.setMaterial(cevsServiceImpl.getById(material.getMId()));break;
            case Constant.MATERIAL_CAPS : materialVo.setMaterial(capsServiceImpl.getById(material.getMId()));break;
            case Constant.MATERIAL_CAWS : materialVo.setMaterial(cawsServiceImpl.getById(material.getMId()));break;
            case Constant.MATERIAL_DEPRESSION_SCALE : materialVo.setMaterial(depressionScaleServiceImpl.getById(material.getMId()));break;
            case Constant.MATERIAL_FACE_EXPRESSION : materialVo.setMaterial(faceExpressionServiceImpl.getById(material.getMId()));break;
        }
        return materialVo;
    }
}
