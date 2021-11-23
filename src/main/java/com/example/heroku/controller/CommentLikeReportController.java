package com.example.heroku.controller;

import com.example.heroku.controller.request.CommentLikeRequest;
import com.example.heroku.controller.request.CommentReportRequest;
import com.example.heroku.entity.Comment;
import com.example.heroku.entity.CommentLikes;
import com.example.heroku.service.CommentLikeService;
import com.example.heroku.service.CommentReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = {"http://localhost:8080","https://esvfront.web.app"}, allowedHeaders = "*")
public class CommentLikeReportController {

    @Autowired
    private CommentLikeService commentLikeService;

    @Autowired
    private CommentReportService commentReportService;

    @PostMapping("/like/{commentNo}")
    public ResponseEntity<Void> RegisterLike(@PathVariable Long commentNo,
                                         @Validated @RequestBody CommentLikeRequest commentLikeRequest)
            throws Exception{

        commentLikeRequest.setCommentNo(commentNo);
        commentLikeService.registerLike(commentLikeRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/report/{commentNo}")
    public ResponseEntity<Void> RegisterReport(@PathVariable Long commentNo,
                                             @Validated @RequestBody CommentReportRequest commentReportRequest)
            throws Exception{

        commentReportRequest.setCommentNo(commentNo);
        commentReportService.registerReport(commentReportRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/like/lists/{commentNo}")
    public ResponseEntity<List<CommentLikes>> getLists(@PathVariable("commentNo") Long commentNo) throws Exception {

        return new ResponseEntity<List<CommentLikes>>(commentLikeService.getLikesOfComment(commentNo),HttpStatus.OK);
    }

    @DeleteMapping("/like/delete/{commentNo}/{memberId}")
    public ResponseEntity<Void> deleteLike(@PathVariable("commentNo") Long commentNo, @PathVariable("memberId")
                                       String memberId) throws Exception{
        commentLikeService.deleteByCommentNoAndMemberId(commentNo, memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/like/check/{commentNo}/{memberId}")
    public ResponseEntity<Boolean> checkMemberDuplicate(@PathVariable("commentNo") Long commentNo,
                                                     @PathVariable("memberId") String memberId) throws Exception{
        Boolean containsMember = commentLikeService.checkMemberDuplicate(commentNo, memberId);

        return new ResponseEntity<Boolean>(containsMember, HttpStatus.OK);
    }

    @GetMapping("/report/check/{commentNo}/{memberId}")
    public ResponseEntity<Boolean> checkReportDuplicate(@PathVariable("commentNo") Long commentNo,
                                                        @PathVariable("memberId") String memberId) throws Exception{
        Boolean containsMember = commentReportService.checkMemberDuplicate(commentNo, memberId);

        return new ResponseEntity<Boolean>(containsMember, HttpStatus.OK);
    }
    @PostMapping("/getReportedCommentNoList")
    public  ResponseEntity<List<Comment>> getReportedCommentNoList () throws  Exception {

        List<Comment> list = commentReportService.getReportedCommentNoList();

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/reportedCommentDelete/{commentNo}")
    public ResponseEntity<Void> reportedCommentDelete (@PathVariable("commentNo") Long commentNo) throws  Exception {

        commentReportService.reportedCommentDelete(commentNo);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
