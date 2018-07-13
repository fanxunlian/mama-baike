package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.utils.DateUtil;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.system.DictionaryEntity;
import com.mama.baike.entity.system.DictionaryQuery;
import com.mama.baike.entity.topic.ForumEntity;
import com.mama.baike.entity.topic.ForumQuery;
import com.mama.baike.entity.topic.TopicEntity;
import com.mama.baike.entity.topic.TopicQuery;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.service.DictionaryService;
import com.mama.baike.service.ForumService;
import com.mama.baike.service.TopicService;
import com.mama.baike.service.UserService;
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

            String strTime = DateUtil.getDisTimeStr(forum.getCreateTime(),new Date())+"前";
            forumLine.put("time",strTime);
            topicForumList.add(forumLine);
        }

        mav.addObject("forumlist",topicForumList);

        return mav;
    }
}