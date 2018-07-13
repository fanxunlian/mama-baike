package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.entity.topic.TopicQuery;
import com.mama.baike.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicRestController {
    @Autowired
    private MongoService mongoService;

    @RequestMapping("/save")
    @AuthIgnore
    public ResultBody saveTopic(TopicQuery topicQuery)
    {
        ResultBody resultBody = new ResultBody();
        mongoService.save(topicQuery,"topic");
        return resultBody;
    }


}
