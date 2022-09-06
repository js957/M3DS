package com.ynufrd.mddds.materialservice.mapper;

import com.ynufrd.mddds.materialservice.entity.po.Material;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ynufrd.mddds.materialservice.entity.po.TemplateGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 材料库 Mapper 接口
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
public interface MaterialMapper extends BaseMapper<Material> {

}
