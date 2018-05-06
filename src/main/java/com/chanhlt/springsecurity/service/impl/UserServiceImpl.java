package com.chanhlt.springsecurity.service.impl;

import com.chanhlt.springsecurity.mapper.UserMapper;
import com.chanhlt.springsecurity.model.User;
import com.chanhlt.springsecurity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User getUserByEmail(String email) {
        return mapper.getUserByEmail(email);
    }

}