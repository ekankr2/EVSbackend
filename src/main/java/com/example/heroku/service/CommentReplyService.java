package com.example.heroku.service;

import com.example.heroku.controller.request.ReplyRequest;
import com.example.heroku.entity.CommentReply;

import java.util.List;

public interface CommentReplyService {
    public void registerReply(ReplyRequest replyRequest) throws Exception;
    public List<CommentReply> getRepliesOfComment(Long commentNo) throws Exception;
    public List<CommentReply> findByReplyNo(Long replyNo) throws Exception;
    public void modify(CommentReply commentReply, ReplyRequest replyRequest) throws Exception;
}
