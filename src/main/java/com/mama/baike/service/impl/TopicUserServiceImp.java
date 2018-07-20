package com.mama.baike.service.impl;

import com.github.pagehelper.PageHelper;
import com.mama.baike.dao.topic.TopicUserDao;
import com.mama.baike.entity.topic.TopicUserEntity;
import com.mama.baike.entity.topic.TopicUserQuery;
import com.mama.baike.service.TopicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("topicUserService")
public class TopicUserServiceImp implements TopicUserService {

    @Autowired
    private TopicUserDao topicUserDao;

    public TopicUserEntity findTopicUser(TopicUserQuery topicUserQuery)
    {
        return topicUserDao.queryObject(topicUserQuery);
    }

    public TopicUserEntity findTopicUserById(Integer id)
    {
        TopicUserQuery topicUserQuery = new TopicUserQuery();
        topicUserQuery.setId(id);
        return topicUserDao.queryObject(topicUserQuery);
    }

    public List<TopicUserEntity> findTopicUserList(TopicUserQuery topicUserQuery)
    {
        PageHelper.startPage(topicUserQuery.getPageIndex(),topicUserQuery.getPageSize());
        return topicUserDao.queryList(topicUserQuery);
    }
}
