package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.topic.TopicEntity;
import com.mama.baike.entity.topic.TopicQuery;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @AuthIgnore
    @RequestMapping(value = "/index")
    public ModelAndView topicIndex(@LoginUser UserEntity user, TopicQuery topicQuery) throws ParseException {
        ModelAndView mav = new ModelAndView("/web/topic/topic");

        List<TopicEntity> topicEntityList =  topicService.findTopicList(topicQuery);
        mav.addObject("topiclist", topicEntityList);
        return mav;
    }
}