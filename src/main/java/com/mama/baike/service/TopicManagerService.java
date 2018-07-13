package com.mama.baike.service;

import com.mama.baike.entity.topic.TopicManagerEntity;
import com.mama.baike.entity.topic.TopicManagerQuery;

import java.util.List;

public interface TopicManagerService {
    /**
     * 查询话题管理员
     */
    public TopicManagerEntity findTopicManager(TopicManagerQuery topicManagerQuery);

    /**
     * 查询话题管理员列表
     */
    public List<TopicManagerEntity> findTopicManagerList(TopicManagerQuery topicManagerQuery);

    /**
     * 查询话题管理员列表
     */
    public List<TopicManagerEntity> findTopicManagerByTopicId(Integer topicId);

}
