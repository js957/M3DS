package com.ynufrd.mddds.collectionservice.controller;


import com.ynufrd.mddds.collectionservice.entity.form.AnswerQuestionForm;
import com.ynufrd.mddds.collectionservice.entity.form.VideoInfoForm;
import com.ynufrd.mddds.collectionservice.entity.form.VideoInfoQueryForm;
import com.ynufrd.mddds.collectionservice.entity.po.AnswerQuestion;
import com.ynufrd.mddds.collectionservice.service.IAnswerQuestionService;
import com.ynufrd.mddds.common.core.vo.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjs
 * @since 2022-08-22
 */
@RestController
@RequestMapping("/collectionservice/answerQuestion")
@Api("answerQuestion")
@Slf4j
public class AnswerQuestionController {

    @Autowired
    IAnswerQuestionService answerQuestionServiceImpl;

    @ApiOperation(value = "上传采集的问题答案", notes = "上传采集的问题答案")
    @ApiImplicitParam(name = "answerQuestionForm", value = "采集问题答案表单", required = true, dataType = "AnswerQuestionForm")
    @PostMapping
    public Result add(@Valid @RequestBody AnswerQuestionForm answerQuestionForm) {
        return Result.success(answerQuestionServiceImpl.save(answerQuestionForm.toPo(AnswerQuestion.class)));
    }


    @ApiOperation(value = "获取采集答案", notes = "获取指定采集视频信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "采集视频ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success();
    }
}
