package com.example.heroku.service;

import com.example.heroku.controller.request.NoticeRequest;
import com.example.heroku.entity.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeService {

    public  void NoticeRegister(Notice notice) throws  Exception;

    public List<Notice> getNoitceList () throws  Exception ;

    public void viewcount(Long boardNo) throws Exception;

    public List<Notice> titleSearchList(String search) throws  Exception;

    public  List<Notice> categorySearchList (String Search) throws  Exception ;

    public Optional<Notice> getNotice(Long boardNo) throws  Exception ;

    public  void noticeModify (Long boardNo, NoticeRequest noticeRequest) throws  Exception ;

    public  void DeleteBoard(Long boardNo) throws  Exception;
}
