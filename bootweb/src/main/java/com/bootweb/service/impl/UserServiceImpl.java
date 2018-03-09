package com.bootweb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bootweb.entity.UserInfo;
import com.bootweb.mapper.AUserInfoMapper;
import com.bootweb.mapper.UserInfoMapper;
import com.bootweb.service.impl.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Resource  
    private UserInfoMapper userInfoMapper;  
    //private AUserInfoMapper aUserInfoMapper;
    
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