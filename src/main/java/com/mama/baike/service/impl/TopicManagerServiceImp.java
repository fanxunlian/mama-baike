package com.mama.baike.service.impl;

import com.mama.baike.dao.topic.TopicManagerDao;
import com.mama.baike.entity.topic.TopicManagerEntity;
import com.mama.baike.entity.topic.TopicManagerQuery;
import com.mama.baike.service.TopicManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicManagerService")
public class TopicManagerServiceImp implements TopicManagerService {

    @Autowired
    private TopicManagerDao topicManagerDao;

    /**
     * 查询话题管理员
     */
    public TopicManagerEntity findTopicManager(TopicManagerQuery topicManagerQuery)
    {
        return topicManagerDao.queryObject(topicManagerQuery);
    }

    /**
     * 查询话题管理员列表
     */
    public List<TopicManagerEntity> findTopicManagerList(TopicManagerQuery topicManagerQuery)
    {
        return topicManagerDao.queryList(topicManagerQuery);
    }
    /**
     * 查询话题管理员列表
     */
    public List<TopicManagerEntity> findTopicManagerByTopicId(Integer topicId)
    {
        TopicManagerQuery topicManagerQuery = new TopicManagerQuery();
        topicManagerQuery.setTopicId(topicId);
        return topicManagerDao.queryList(topicManagerQuery);
    }

}
