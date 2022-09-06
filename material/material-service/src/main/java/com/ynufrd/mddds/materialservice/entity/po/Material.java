package com.ynufrd.mddds.materialservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 材料库
 * </p>
 *
 * @author wjs
 * @since 2022-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 材料库名(表明)
     */
    private String materialName;

    /**
     * 材料类型(word、text、video、audio、picture)
     */
    private String type;

    /**
     * 由材料表名与m_id具体的指向某个材料表的一个材料
     */
    private String mId;

    /**
     * 材料预览地址
     */
    private String urlPreview;




}
