package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.system.DictionaryEntity;
import com.mama.baike.entity.system.DictionaryQuery;
import com.mama.baike.entity.topic.TopicEntity;
import com.mama.baike.entity.topic.TopicQuery;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.service.DictionaryService;
import com.mama.baike.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private DictionaryService dictionaryService;

    @AuthIgnore
    @RequestMapping(value = "/index")
    public ModelAndView topicIndex(@LoginUser UserEntity user) throws ParseException {
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
}