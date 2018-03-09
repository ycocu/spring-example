package com.bootweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bootweb.entity.UserInfo;

import io.lettuce.core.dynamic.annotation.Param;

//@Mapper
public interface AUserInfoMapper {
/*
    
    @Results(value={
            @Result(id=true, property="id", column="ID"),
            @Result(property="userName", column="user_name"),
            @Result(property="createTime", column="create_time"),
            @Result(property="updateTime", column="update_time"),
    })
    @Select("select * from user_info where ID=#{id}")
    UserInfo selectByPrimaryKey(@Param("id") int id);
*/
}
