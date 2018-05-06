package com.chanhlt.springsecurity.service;

import com.chanhlt.springsecurity.model.User;

public interface UserService{
    User getUserByEmail(String email);
}