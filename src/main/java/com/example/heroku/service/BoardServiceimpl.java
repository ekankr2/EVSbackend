package com.example.heroku.service;

import com.example.heroku.controller.request.BoardReportRequest;
import com.example.heroku.controller.request.BoardRequest;
import com.example.heroku.entity.Board;
import com.example.heroku.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import utility.python.BoardReportKakaoAlarmWithPython;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceimpl implements  BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void boardRegister(BoardRequest boardRequest) throws Exception {

        Board board = new Board(boardRequest.getMemberId(), boardRequest.getTitle(), boardRequest.getContent(), boardRequest.getImg(), boardRequest.getCategory());

        boardRepository.save(board);
    }

    @Override
    public List<Board> getBoardList() throws Exception {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public Optional<Board> getBoard(Long boardNo) throws Exception {
        return boardRepository.findById(boardNo);
    }

    @Override
    public void viewcount(Long boardNo) throws Exception {
        boardRepository.viewcount(boardNo);
    }

    @Override
    public void goodCount(Long boardNo) throws Exception {
        boardRepository.goodCount(boardNo);
    }

    @Override
    public void badCount(Long boardNo) throws Exception {
        boardRepository.badCount(boardNo);
    }

    @Override
    public void report(Long boardNo, String reportWord) throws Exception {
        boardRepository.report(boardNo, reportWord);
    }

    @Override
    public void boardModify(BoardRequest boardRequest, Long boardNo) throws Exception {
        String title = boardRequest.getTitle();
        String content = boardRequest.getContent();
        String img = boardRequest.getImg();
        boardRepository.boardModifyAtTitle(title, boardNo);
        boardRepository.boardModifyAtcontent(content, boardNo);
        boardRepository.boardModifyAtimg(img, boardNo);
    }

    @Override
    public void DeleteBoard(Long boardNo) throws Exception {
        System.out.println(boardNo);
        boardRepository.deleteById(boardNo);
    }

    @Override
    public List<Board> getTargetList(String target) throws Exception {

        return boardRepository.getTargetList(target);
    }

    @Override
    public List<Board> titleSearchList(String search) throws Exception {
        return boardRepository.titleSearchList(search);
    }

    @Override
    public List<Board> memberIdSearchList(String search) throws Exception {
        return boardRepository.memberIdSearchList(search);
    }

    @Override
    public String KakaotalkAlarm(BoardReportRequest boardReportRequest) throws Exception {

        BoardReportKakaoAlarmWithPython BRKWP = new BoardReportKakaoAlarmWithPython();


        return BRKWP.KakaotalkAlarm(boardReportRequest);
    }

    @Override
    public List<Board> getReportedBoardList() throws Exception {
        String report = "신고됨";
        return boardRepository.getReportedBoardList(report);
    }

    @Override
    public List<Board> reportedTitleSearchList(String search) throws Exception {
        String report = "신고됨";

       List<Board> list = boardRepository.titleSearchList(search);

       /*
       List<Board> list2 =null;
       for(int i = 0 ; i< list.toArray().length;  i++){
           if(list.get(9).equals(report)) {

           }
       }

        */


        return list;

    }

    @Override
    public List<Board> reportedMemberIdSearchList(String search) throws Exception {

        String report = "신고됨";
        List<Board> list =  boardRepository.memberIdSearchList(search);
        return list;
    }

    @Override
    public List<Board> findByMemberId(String memberId) throws Exception {
        return boardRepository.findByMemberId(memberId);
    }
}
