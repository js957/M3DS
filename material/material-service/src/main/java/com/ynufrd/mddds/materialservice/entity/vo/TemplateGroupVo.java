package com.ynufrd.mddds.materialservice.entity.vo;

import com.ynufrd.mddds.common.web.entity.vo.BaseVo;
import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.ynufrd.mddds.materialservice.entity.po.TemplateExperimental;
import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wjs on 2022/08/21
 */
@Data
@NoArgsConstructor
public class TemplateGroupVo extends BaseVo<TemplateGroup> {

    public TemplateGroupVo(TemplateGroup templateGroup){
        BeanUtils.copyProperties(templateGroup, this);
    }

    /**
     * 一组实验组名
     */
    private String groupName;

    /**
     * 实验持续时间
     */
    private Integer duration;

    /**
     * 实验最短允许时间
     */
    private Integer durationMin;

    /**
     * 实验内容
     */
    private String content;
    /**
     * 组实验前的文字提示
     */
    private String tipsBfExpText;
    /**
     * 组实验后的文字提示
     */
    private String tipsAfExpText;

    private String tempProceId;

    private Integer sequence;

    private List<String> experimentalList;

}
