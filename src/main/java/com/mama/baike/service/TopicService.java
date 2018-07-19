package com.mama.baike.service;

import com.mama.baike.entity.topic.TopicEntity;
import com.mama.baike.entity.topic.TopicQuery;

import java.util.List;

public interface TopicService {
    /**
     * 查询话题
     */
    public TopicEntity findTopic(TopicQuery topicQuery);
    /**
     * 查询话题
     */
    public TopicEntity findTopicById(Integer id);
    /**
     * 查询话题列表
     */
    public List<TopicEntity> findTopicList(TopicQuery topicQuery);
}
