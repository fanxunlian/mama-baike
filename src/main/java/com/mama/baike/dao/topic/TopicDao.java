package com.mama.baike.dao.topic;

import com.mama.baike.dao.base.BaseDao;
import com.mama.baike.entity.topic.TopicEntity;
import com.mama.baike.entity.topic.TopicQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicDao  extends BaseDao<TopicEntity,TopicQuery> {

}
