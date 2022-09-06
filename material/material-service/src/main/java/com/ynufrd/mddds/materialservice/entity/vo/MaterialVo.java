package com.ynufrd.mddds.materialservice.entity.vo;

import com.ynufrd.mddds.common.web.entity.vo.BaseVo;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Created by wjs on 2022/08/21
 */
@Data
@NoArgsConstructor
public class MaterialVo extends BaseVo<Material> {

    public MaterialVo(Material material){
        BeanUtils.copyProperties(material, this);
    }

    /**
     * 材料库名(表明)
     */
    private String materialName;

    /**
     * 材料类型(word、text、video、audio、picture,question)
     */
    private String type;

    private Object material;
}
