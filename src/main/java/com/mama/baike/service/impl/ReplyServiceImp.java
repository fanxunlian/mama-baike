package com.mama.baike.service.impl;

import com.mama.baike.dao.topic.ReplyDao;
import com.mama.baike.entity.topic.ReplyEntity;
import com.mama.baike.entity.topic.ReplyQuery;
import com.mama.baike.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("replyService")
public class ReplyServiceImp implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    public ReplyEntity findReply(ReplyQuery replyQuery)
    {
        return replyDao.queryObject(replyQuery);
    }

    public ReplyEntity findReplyById(Integer id)
    {
        ReplyQuery replyQuery = new ReplyQuery();
        replyQuery.setId(id);
        return replyDao.queryObject(replyQuery);
    }

    public List<ReplyEntity> findReplyList(ReplyQuery replyQuery)
    {
        return replyDao.queryList(replyQuery);
    }
}
