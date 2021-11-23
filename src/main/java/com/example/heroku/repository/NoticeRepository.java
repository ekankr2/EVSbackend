package com.example.heroku.repository;

import com.example.heroku.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Notice n set n.viewcount = n.viewcount +1  where n.boardNo = :boardNo")
    void viewcount (Long boardNo);


    @Query("select t from Notice t where t.title = :search")
    List<Notice> titleSearchList(String search);

    @Query("select t from Notice t where t.category = :search")
    List<Notice> categorySearchList(String search);


    @Transactional
    @Modifying
    @Query("UPDATE Notice b set b.title = :title where b.boardNo = :boardNo")
    void boardModifyAtTitle(String title, Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE Notice b set b.content = :content where b.boardNo = :boardNo")
    void boardModifyAtcontent(String content, Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE Notice b set b.img = :img where b.boardNo = :boardNo")
    void boardModifyAtimg(String img, Long boardNo);
}
