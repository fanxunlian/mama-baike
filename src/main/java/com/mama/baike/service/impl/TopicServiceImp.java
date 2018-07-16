package com.mama.baike.service.impl;

import com.mama.baike.dao.topic.TopicDao;
import com.mama.baike.entity.topic.TopicEntity;
import com.mama.baike.entity.topic.TopicQuery;
import com.mama.baike.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImp implements TopicService {
    @Autowired
    private TopicDao topicDao;
    /**
     * 查询话题
     */
    public TopicEntity findTopic(TopicQuery topicQuery)
    {
        return topicDao.queryObject(topicQuery);
    }
    /**
     * 查询话题列表
     */
    public List<TopicEntity> findTopicList(TopicQuery topicQuery)
    {
        return topicDao.queryList(topicQuery);
    }

}
