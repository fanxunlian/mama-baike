package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.dao.topic.TopicDao;
import com.mama.baike.entity.topic.*;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.service.MongoService;
import com.mama.baike.service.TopicService;
import com.mama.baike.service.TopicUserService;
import com.mama.baike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicRestController {
    @Autowired
    private MongoService mongoService;
    @Autowired
    private TopicUserService topicUserService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;

    @RequestMapping("/forum/save")
    @AuthIgnore
    public ResultBody saveTopic(@RequestBody  ForumQuery forumQuery)
    {
        ResultBody resultBody = new ResultBody();
        mongoService.save(forumQuery,"topic");
        return resultBody;
    }
    @RequestMapping("/user/list")
    @AuthIgnore
    public ResultBody indexTopicUser(@RequestBody  TopicUserQuery topicUserQuery)
    {
        ResultBody resultBody = new ResultBody();
        List<TopicUserEntity> topicUserList = topicUserService.findTopicUserList(topicUserQuery);
        for(TopicUserEntity topicUserEntity:topicUserList)
        {
            if(topicUserQuery.getUserId() != null) {
                TopicEntity topicEntity = topicService.findTopicById(topicUserEntity.getTopicId());
                topicUserEntity.setTopicEntity(topicEntity);
            }
            if(topicUserQuery.getTopicId()!= null) {
                UserEntity userEntity = userService.findUserById(topicUserEntity.getUserId());
                topicUserEntity.setUserEntity(userEntity);
            }
        }
        resultBody.setData(topicUserList);
        return resultBody;
    }


}
