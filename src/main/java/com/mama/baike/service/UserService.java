package com.mama.baike.service;

import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.entity.user.UserQuery;

public interface UserService {

    /**
     * 登录
     */
    public UserEntity login(UserQuery userQuery);
}