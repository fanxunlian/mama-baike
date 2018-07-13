package com.mama.baike.service.impl;

import com.mama.baike.dao.user.UserDao;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.entity.user.UserQuery;
import com.mama.baike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 登录
     */
    public UserEntity login(UserQuery userQuery) {
        return userDao.queryObject(userQuery);
    }
    /**
     * 查询用户
     */
    public UserEntity findUser(UserQuery userQuery)
    {
        return userDao.queryObject(userQuery);
    }
    /**
     * 根据id查询用户
     */
    public UserEntity findUserById(Integer id)
    {
        UserQuery userQuery = new UserQuery();
        userQuery.setId(id);
        return userDao.queryObject(userQuery);
    }
}
