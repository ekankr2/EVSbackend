package com.example.heroku.service;

import com.example.heroku.controller.request.BoardReportRequest;
import com.example.heroku.controller.request.BoardRequest;
import com.example.heroku.controller.request.MemberRequest;
import com.example.heroku.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    public  void boardRegister (BoardRequest boardRequest) throws  Exception;

    public List<Board> getBoardList () throws  Exception;

    public Optional<Board> getBoard(Long boardNo)throws  Exception;

    public void viewcount(Long boardNo) throws  Exception;

    public void goodCount (Long boardNo) throws  Exception;

    public void badCount (Long boardNo) throws  Exception;

    public void report (Long boardNo, String reportWord) throws  Exception;

    public  void boardModify (BoardRequest boardRequest, Long boardNo) throws  Exception;

    public  void DeleteBoard (Long boardNo) throws  Exception ;

    public List<Board> getTargetList (String target) throws  Exception ;

    public List<Board> titleSearchList (String search) throws  Exception ;

    public List<Board> memberIdSearchList (String search) throws  Exception ;

    public String KakaotalkAlarm(BoardReportRequest boardReportRequest)throws Exception;

    public  List<Board> getReportedBoardList () throws  Exception;

    public  List<Board> reportedTitleSearchList(String search) throws  Exception;

    public  List<Board> reportedMemberIdSearchList (String search) throws  Exception;

    public List<Board> findByMemberId(String memberId) throws Exception;

    public  void ReportPass (Long boardNo) throws  Exception ;
}
