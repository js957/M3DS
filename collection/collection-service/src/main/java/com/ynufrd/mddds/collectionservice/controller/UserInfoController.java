package com.ynufrd.mddds.collectionservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ynufrd.mddds.collectionservice.entity.form.UserInfoForm;
import com.ynufrd.mddds.collectionservice.entity.form.UserInfoQueryForm;
import com.ynufrd.mddds.collectionservice.entity.po.UserInfo;
import com.ynufrd.mddds.collectionservice.service.IUserInfoService;
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
@RequestMapping("/collectionservice/userInfo")
@Api("userInfo")
@Slf4j
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoServiceImpl;

    @ApiOperation(value = "新用户进行测试", notes = "新用户进行测试")
    @ApiImplicitParam(name = "userInfoForm", value = "新用户表单", required = true, dataType = "UserInfoForm")
    @PostMapping
    public Result add(@Valid @RequestBody UserInfoForm userInfoForm) {
        UserInfo userInfo = userInfoForm.toPo(UserInfo.class);
        userInfoServiceImpl.save(userInfo);
        return Result.success(userInfo.getId());
    }


    @ApiOperation(value = "获取用户采集信息", notes = "获取指定用户采集信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(userInfoServiceImpl.getById(id));
    }


    @ApiOperation(value = "搜索用户采集信息", notes = "根据条件查询用户采集信息")
    @ApiImplicitParam(name = "userInfoQueryForm", value = "用户筛选参数", required = true, dataType = "UserInfoQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result search(@Valid @RequestBody UserInfoQueryForm userInfoQueryForm) {
        return Result.success();
    }
}
