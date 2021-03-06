package com.mama.baike.service;

import com.mama.baike.entity.topic.ForumEntity;
import com.mama.baike.entity.topic.ForumQuery;

import java.util.List;

public interface ForumService {
    /**
     * 话题内容列表
     */
    public ForumEntity findForum(ForumQuery forumQuery);
    /**
     * 根据Id话题内容列表
     */
    public ForumEntity findForumById(Integer id);
    /**
     * 话题内容列表
     */
    public List<ForumEntity> findForumList(ForumQuery forumQuery);
}
