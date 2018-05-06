package com.chanhlt.springsecurity.mapper;

import com.chanhlt.springsecurity.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserByEmail(@Param("email") String email);
}