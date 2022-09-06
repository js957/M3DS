package com.ynufrd.mddds.collectionservice.entity.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.ynufrd.mddds.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjs
 * @since 2022-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoInfo extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 采集的材料名(用户标识_实验标识_时间标识)
     */
    private String name;

    /**
     * 采集的用户
     */
    private String userId;

    /**
     * 哪个实验
     */
    private String tempExpId;


    /**
     * 图片浏览地址
     */
    private String urlPreview;

    /**
     * 图片下载地址
     */
    private String urlDownload;

    /**
     * 存储桶
     */
    private String bucketName;


}
