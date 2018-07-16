package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.utils.DateUtil;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.mongo.ContentEntity;
import com.mama.baike.entity.system.DictionaryEntity;
import com.mama.baike.entity.system.DictionaryQuery;
import com.mama.baike.entity.topic.*;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ForumService forumService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private TopicManagerService topicManagerService;

    @Autowired
    private MongoService mongoService;

    @AuthIgnore
    @RequestMapping(value = "/index")
    public ModelAndView topicIndex(@LoginUser UserEntity user){
        ModelAndView mav = new ModelAndView("/web/topic/index");
        List<Map<String,Object>> mapList = new LinkedList<>();

        String topicTypeIndex = dictionaryService.findDictionaryByCode("topic.type.index");

        DictionaryQuery dictionaryQuery = new DictionaryQuery();
        dictionaryQuery.setParentId(Integer.parseInt(topicTypeIndex));

        List<DictionaryEntity> dictionaryEntityList = dictionaryService.findDictionaryList(dictionaryQuery);

        for ( DictionaryEntity dictionaryEntity: dictionaryEntityList) {
            TopicQuery topicQuery = new TopicQuery();
            topicQuery.setTopicType(topicTypeIndex);
            topicQuery.setClassType(dictionaryEntity.getValue());
            List<TopicEntity> topicEntityList =  topicService.findTopicList(topicQuery);
            Map<String,Object>map = new HashMap<>();
            map.put("title",dictionaryEntity);
            map.put("topiclist",topicEntityList);
            if(!topicEntityList.isEmpty()) {
                mapList.add(map);
            }

        }

        mav.addObject("topicmaplist", mapList);
        return mav;
    }

    /**
     * 话题查询
     */
    @AuthIgnore
    @RequestMapping(value = "/forum")
    public ModelAndView findTopicForum(@LoginUser UserEntity user, HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView("/web/topic/forum");
        List<Map<String,Object>> topicForumList = new LinkedList<>();
        List<UserEntity> managerList = new LinkedList<>();

        Integer topicId = Integer.parseInt(request.getParameter("id"));
        TopicQuery topicQuery = new TopicQuery();
        topicQuery.setId(topicId);
        List<TopicEntity> topicList = topicService.findTopicList(topicQuery);
        if(!topicList.isEmpty())
        {
            mav.addObject("topic",topicList.get(0));
        }

        ForumQuery forumQuery = new ForumQuery();
        forumQuery.setTopicId(topicId);
        List<ForumEntity> forumList = forumService.findForumList(forumQuery);

        for (ForumEntity forum : forumList)
        {
            Map<String,Object>forumLine = new HashMap<>();
            UserEntity creatorUser = userService.findUserById(forum.getCreatorId());
            forumLine.put("creator",creatorUser);
            forumLine.put("forum",forum);

            String strTime = DateUtil.getDisTimeStr(forum.getCreateTime(),new Date());
            forumLine.put("time",strTime);
            topicForumList.add(forumLine);
        }

        mav.addObject("forumlist",topicForumList);


        List<TopicManagerEntity> topicManagerList = topicManagerService.findTopicManagerByTopicId(topicId);
        for (TopicManagerEntity topicManagerEntity :topicManagerList)
        {
            UserEntity userEntity = userService.findUserById(topicManagerEntity.getUserId());
            managerList.add(userEntity);
        }
        mav.addObject("managerlist",managerList);

        return mav;
    }
    /**
     * 论坛内容查询
     */
    @AuthIgnore
    @RequestMapping(value = "/card")
    public ModelAndView findCardForum(@LoginUser UserEntity user, HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView("/web/topic/card");
        List<Map<String,Object>> topicForumList = new LinkedList<>();
        List<UserEntity> managerList = new LinkedList<>();

        Integer forumId = Integer.parseInt(request.getParameter("id"));
        ForumEntity forum = forumService.findForumById(forumId);
        mav.addObject("forum",forum);

        ContentEntity contentEntity = mongoService.queryObject(forum.getContentUid());
        forum.setContent(contentEntity.getContent());
        UserEntity userEntity = userService.findUserById(forum.getCreatorId());
        mav.addObject("creator",userEntity);

        return mav;
    }
}