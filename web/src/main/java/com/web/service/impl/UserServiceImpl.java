package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.entity.UserInfo;
import com.web.mapper.UserInfoMapper;

@Service
public class UserServiceImpl implements UserService{

    @Resource  
    private UserInfoMapper userInfoMapper;  
  
    public Integer insert(UserInfo userInfo) {  
        return userInfoMapper.insertSelective(userInfo);  
    }  
  
    public Integer delete(Integer uid) {
        return userInfoMapper.deleteByPrimaryKey(uid);  

    }

    public UserInfo select(Integer uid) {
        return userInfoMapper.selectByPrimaryKey(uid);  

    }
}
