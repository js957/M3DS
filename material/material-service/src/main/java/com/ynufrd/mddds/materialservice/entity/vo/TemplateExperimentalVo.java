package com.ynufrd.mddds.materialservice.entity.vo;

import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.entity.po.TemplateExperimental;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Created by wjs on 2022/08/21
 */
@Data
@NoArgsConstructor
public class TemplateExperimentalVo {

    public TemplateExperimentalVo(TemplateExperimental templateExperimental){
        BeanUtils.copyProperties(templateExperimental, this);
    }

    /**
     * 实验持续时间(单位s，0为时间不限)
     */
    private Integer duration;

    /**
     * 实验名
     */
    private String expName;

    /**
     * 材料id
     */
    private MaterialVo material;

    /**
     * 实验前文本提示
     */
    private String tipsBfExpText;


    /**
     * 实验后文本提示
     */
    private String tipsAfExpText;


    /**
     * 所属的组
     */
    private String tempGroupId;

    /**
    * 顺序
    */
    private Integer sequence;
}
