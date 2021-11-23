package com.example.heroku.service;

import com.example.heroku.controller.request.CommentRequest;
import com.example.heroku.entity.Comment;

import java.util.List;
import java.util.Optional;


public interface CommentService {
    public void register(CommentRequest commentRequest) throws Exception;
    public List<Comment> getCommentsOfBoard(Long boardNo) throws Exception;
    public List<Comment> findByCommentNo(Long commentNo) throws Exception;
    public void modify(Comment comment, CommentRequest commentRequest) throws Exception;
    public void delete(Comment comment, CommentRequest commentRequest) throws Exception;
    public Optional<Comment> getRePortedComment(Long commentNo) throws  Exception;
    public List<Comment> findByMemberId(String memberId) throws Exception;
}
