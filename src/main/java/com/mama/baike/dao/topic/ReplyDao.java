package com.mama.baike.dao.topic;

import com.mama.baike.dao.base.BaseDao;
import com.mama.baike.entity.topic.ReplyEntity;
import com.mama.baike.entity.topic.ReplyQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyDao  extends BaseDao<ReplyEntity,ReplyQuery> {
}
