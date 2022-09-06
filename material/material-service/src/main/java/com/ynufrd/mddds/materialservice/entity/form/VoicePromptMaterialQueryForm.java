package com.ynufrd.mddds.materialservice.entity.form;

import com.ynufrd.mddds.common.web.entity.form.BaseQueryForm;
import com.ynufrd.mddds.materialservice.entity.param.VoicePromptMaterialQueryParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by wjs on 2022/08/19
 */
@ApiModel
@Data
public class VoicePromptMaterialQueryForm extends BaseQueryForm<VoicePromptMaterialQueryParam> {
}
