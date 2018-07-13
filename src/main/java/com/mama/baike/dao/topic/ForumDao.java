package com.mama.baike.dao.topic;

import com.mama.baike.dao.base.BaseDao;
import com.mama.baike.entity.topic.ForumEntity;
import com.mama.baike.entity.topic.ForumQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ForumDao extends BaseDao<ForumEntity,ForumQuery>{

}
