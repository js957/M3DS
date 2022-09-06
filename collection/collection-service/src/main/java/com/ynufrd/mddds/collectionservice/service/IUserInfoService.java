package com.ynufrd.mddds.collectionservice.service;

import com.ynufrd.mddds.collectionservice.entity.po.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ynufrd.mddds.collectionservice.entity.vo.UserInfoVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjs
 * @since 2022-08-22
 */
public interface IUserInfoService extends IService<UserInfo> {

    public UserInfoVo get(String id);
}
