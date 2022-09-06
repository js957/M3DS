package com.ynufrd.mddds.collectionservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.collectionservice.config.Constant;
import com.ynufrd.mddds.collectionservice.entity.form.VideoInfoForm;
import com.ynufrd.mddds.collectionservice.entity.form.VideoInfoQueryForm;
import com.ynufrd.mddds.collectionservice.entity.po.VideoInfo;
import com.ynufrd.mddds.collectionservice.provider.FileServiceProvider;
import com.ynufrd.mddds.collectionservice.service.IVideoInfoService;
import com.ynufrd.mddds.common.core.vo.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-22
 */
@RestController
@RequestMapping("/collectionservice/videoInfo")
@Api("videoInfo")
@Slf4j
public class VideoInfoController {

    @Autowired
    FileServiceProvider fileServiceProvider;

    @Autowired
    IVideoInfoService videoInfoServiceImpl;

    @ApiOperation(value = "上传采集视频", notes = "上传采集视频")
    @ApiImplicitParam(name = "videoInfoForm", value = "采集视频表单", required = true, dataType = "VideoInfoForm")
    @PostMapping
    public Result add(@Valid VideoInfoForm videoInfoForm) {
        VideoInfo videoInfo = videoInfoForm.toPo(VideoInfo.class);
        String bucketName = Constant.COLLECTION_VIDEO + "-" + videoInfoForm.getUserId() + "-" + videoInfoForm.getTempExpId();
        Result<String> result = fileServiceProvider.upload(videoInfoForm.getFile(), bucketName);
        videoInfo.setName(bucketName);
        videoInfo.setBucketName(Constant.COLLECTION);
        videoInfo.setUrlPreview(Constant.getPreviewUri(result.getData().toString(),Constant.COLLECTION));
        videoInfo.setUrlDownload(Constant.getDownloadUri(result.getData().toString(),Constant.COLLECTION));
        return Result.success(videoInfoServiceImpl.save(videoInfo));
    }


    @ApiOperation(value = "获取采集视频", notes = "获取指定采集视频信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "采集视频ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(videoInfoServiceImpl.getById(id));
    }


    @ApiOperation(value = "搜索采集材料", notes = "根据条件查询采集材料信息")
    @ApiImplicitParam(name = "videoInfoQueryForm", value = "采集视频查询参数", required = true, dataType = "VideoInfoQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody VideoInfoQueryForm videoInfoQueryForm) {
        return Result.success();
    }
}
