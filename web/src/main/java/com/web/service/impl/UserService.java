/**
 * 
 */
package com.web.service.impl;

import org.springframework.stereotype.Service;

import com.web.entity.UserInfo;

/**
 * @author yujunjie01
 *
 */
public interface UserService {
    
    Integer insert(UserInfo userInfo);
    Integer delete(Integer uid);
    UserInfo select(Integer uid);
}
