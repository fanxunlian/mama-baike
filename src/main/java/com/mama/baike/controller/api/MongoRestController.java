package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.entity.mongo.ContentEntity;
import com.mama.baike.entity.topic.ForumQuery;
import com.mama.baike.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mongo")
public class MongoRestController {

    @Autowired
    private MongoService mongoService;

    @RequestMapping("/forum/save")
    @AuthIgnore
    public ResultBody saveContent(@RequestBody ContentEntity contentEntity)
    {
        ResultBody resultBody = new ResultBody();
        mongoService.save(contentEntity,"content");
        return resultBody;
    }

    @RequestMapping("/forum/index")
    @AuthIgnore
    public ResultBody indexContent(@RequestBody String uuid)
    {
        ResultBody resultBody = new ResultBody();
        ContentEntity content = mongoService.queryObject(uuid,ContentEntity.class,"content");
        resultBody.setData(content);
        return resultBody;
    }



}