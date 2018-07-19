package com.mama.baike.service;

import com.mama.baike.entity.topic.TopicUserEntity;
import com.mama.baike.entity.topic.TopicUserQuery;

import java.util.List;

public interface TopicUserService {

    public TopicUserEntity findTopicUser(TopicUserQuery topicUserQuery);

    public TopicUserEntity findTopicUserById(Integer id);

    public List<TopicUserEntity> findTopicUserList(TopicUserQuery topicUserQuery);
}
