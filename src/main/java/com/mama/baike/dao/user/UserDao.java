package com.mama.baike.dao.user;

import com.mama.baike.dao.base.BaseDao;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.entity.user.UserQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao<UserEntity,UserQuery>{
}
