package com.mama.baike.dao.topic;

import com.mama.baike.dao.base.BaseDao;
import com.mama.baike.entity.topic.TopicManagerEntity;
import com.mama.baike.entity.topic.TopicManagerQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicManagerDao extends BaseDao<TopicManagerEntity,TopicManagerQuery> {
}
