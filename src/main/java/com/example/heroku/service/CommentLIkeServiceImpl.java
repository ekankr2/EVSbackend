package com.example.heroku.service;

import com.example.heroku.controller.request.CommentLikeRequest;
import com.example.heroku.entity.CommentLikes;
import com.example.heroku.repository.CommentLikeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentLIkeServiceImpl implements CommentLikeService {

    @Autowired
    private CommentLikeRepository commentLikeRepository;

    @Override
    public void registerLike(CommentLikeRequest commentLikeRequest) throws Exception {
        CommentLikes commentLikes = new CommentLikes(commentLikeRequest.getLikeNo(), commentLikeRequest.getCommentNo(),
                commentLikeRequest.getMemberId());

        commentLikeRepository.save(commentLikes);
    }

    @Override
    public List<CommentLikes> getLikesOfComment(Long commentNo) throws Exception {
        return commentLikeRepository.getLikesOfComment(commentNo);
    }

    @Override
    public void deleteByCommentNoAndMemberId(Long commentNo, String memberId) throws Exception {

        commentLikeRepository.deleteByCommentNoAndMemberId(commentNo, memberId);
    }

    @Override
    public Boolean checkMemberDuplicate(Long commentNo, String memberId) throws Exception {
        Optional<CommentLikes> maybeMember = commentLikeRepository.findByCommentNoAndMemberId(commentNo, memberId);

        return maybeMember.isPresent();
    }
}
