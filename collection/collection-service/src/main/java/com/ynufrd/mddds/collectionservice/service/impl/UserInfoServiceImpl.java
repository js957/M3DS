package com.ynufrd.mddds.collectionservice.service.impl;

import com.ynufrd.mddds.collectionservice.entity.po.UserInfo;
import com.ynufrd.mddds.collectionservice.entity.vo.UserInfoVo;
import com.ynufrd.mddds.collectionservice.mapper.UserInfoMapper;
import com.ynufrd.mddds.collectionservice.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wjs
 * @since 2022-08-22
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {




    @Override
    public UserInfoVo get(String id) {
        return null;
    }
}
