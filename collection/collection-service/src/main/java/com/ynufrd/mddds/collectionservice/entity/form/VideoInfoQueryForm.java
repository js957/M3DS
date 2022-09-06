package com.ynufrd.mddds.collectionservice.entity.form;

import com.ynufrd.mddds.collectionservice.entity.param.VideoInfoQueryParam;
import com.ynufrd.mddds.common.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by wjs on 2022/08/22
 */
@ApiModel
@Data
public class VideoInfoQueryForm extends BaseQueryForm<VideoInfoQueryParam> {
}
