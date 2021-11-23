package com.example.heroku.service;

import com.example.heroku.controller.request.CommentLikeRequest;
import com.example.heroku.entity.CommentLikes;

import java.util.List;

public interface CommentLikeService {
    public void registerLike(CommentLikeRequest commentLikeRequest) throws Exception;
    public List<CommentLikes> getLikesOfComment(Long commentNo) throws Exception;
    public void deleteByCommentNoAndMemberId(Long commentNo, String memberId)throws Exception;
    public Boolean checkMemberDuplicate(Long commentNo, String memberId)throws Exception;
}
