package com.mama.baike.service;

import com.mama.baike.entity.topic.ReplyEntity;
import com.mama.baike.entity.topic.ReplyQuery;

import java.util.List;

public interface ReplyService {

    public ReplyEntity findReply(ReplyQuery replyQuery);

    public ReplyEntity findReplyById(Integer id);

    public List<ReplyEntity> findReplyList(ReplyQuery replyQuery);
}
