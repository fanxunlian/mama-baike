package com.mama.baike.dao.topic;

import com.mama.baike.dao.base.BaseDao;
import com.mama.baike.entity.topic.TopicUserEntity;
import com.mama.baike.entity.topic.TopicUserQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicUserDao extends BaseDao<TopicUserEntity,TopicUserQuery>{
}
