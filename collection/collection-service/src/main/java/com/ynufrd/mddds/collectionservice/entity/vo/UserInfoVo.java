package com.ynufrd.mddds.collectionservice.entity.vo;

import com.ynufrd.mddds.collectionservice.entity.po.UserInfo;
import com.ynufrd.mddds.common.web.entity.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;

/**
 * Created by wjs on 2022/08/24
 */
@Data
@NoArgsConstructor
public class UserInfoVo extends BaseVo<UserInfo> {

    UserInfoVo(UserInfo userInfo){
        BeanUtils.copyProperties(userInfo,this);
    }

    /**
     * 用户名
     */
    private String userName;


    /**
     * 性别(1=男，0=女)
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 是否抑郁症
     */
    private Boolean depression;

    /**
     * 抑郁等级
     */
    private Integer depressionLevel;

    /**
     * 量表分数
     */
    private Integer depressionScore;

    private HashMap<String,String> collectionList;
}
