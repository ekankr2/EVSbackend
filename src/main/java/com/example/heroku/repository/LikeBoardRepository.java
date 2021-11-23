package com.example.heroku.repository;

import com.example.heroku.entity.LikeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface LikeBoardRepository extends JpaRepository<LikeBoard, Long> {

    @Query("select u.boardNo from LikeBoard u where u.memberNo = :memberNo")
    ArrayList  findByBoardNo(Long memberNo);
}
