package com.example.heroku.service;

import com.example.heroku.controller.request.CommentReportRequest;
import com.example.heroku.entity.Comment;
import com.example.heroku.entity.CommentReport;

import java.util.List;

public interface CommentReportService {
    public void registerReport(CommentReportRequest commentReportRequest) throws Exception;
    public List<CommentReport> getReportsOfComment(Long commentNo) throws Exception;
    public void deleteByCommentNoAndMemberId(Long commentNo, String memberId)throws Exception;
    public Boolean checkMemberDuplicate(Long commentNo, String memberId)throws Exception;
    public List<Comment> getReportedCommentNoList () throws  Exception;
    public  void reportedCommentDelete(Long commentNo)throws  Exception;
}
