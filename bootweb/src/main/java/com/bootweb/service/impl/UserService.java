package com.bootweb.service.impl;

import com.bootweb.entity.UserInfo;

public interface UserService {
    
    Integer insert(UserInfo userInfo);
    Integer delete(Integer uid);
    UserInfo select(Integer uid);
}
