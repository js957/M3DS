package com.ynufrd.mddds.materialservice.entity.vo;

import com.ynufrd.mddds.common.web.entity.vo.BaseVo;
import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import com.ynufrd.mddds.materialservice.entity.po.TemplateProcedure;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wjs on 2022/08/19
 */
@Data
@NoArgsConstructor
public class TemplateProcedureVo extends BaseVo<TemplateProcedure> {

    public TemplateProcedureVo(TemplateProcedure procedure, List<TemplateGroup> groups){
        this.proName = procedure.getProName();
        this.expSequence = groups.stream().map(TemplateGroup::getContent).collect(Collectors.toList());
        this.expGroupIds = groups.stream().map(TemplateGroup::getId).collect(Collectors.toList());
    }
    /**
     * 实验模板名
     */
    private String proName;

    private List<String> expSequence;
    // [depressionScale,image,video]

    private List<String> expGroupIds;
    /**
    * [1,5,7]
    */

}
