package com.mama.baike.service.impl;

import com.mama.baike.dao.topic.ForumDao;
import com.mama.baike.entity.topic.ForumEntity;
import com.mama.baike.entity.topic.ForumQuery;
import com.mama.baike.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("forumService")
public class ForumServiceImp implements ForumService {
    @Autowired
    private ForumDao forumDao;

    /**
     * 话题内容列表
     */
    public List<ForumEntity> findForumList(ForumQuery forumQuery)
    {
        return forumDao.queryList(forumQuery);
    }
}
