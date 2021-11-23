package com.example.heroku.repository;

import com.example.heroku.entity.HateBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface HateBoardRepository extends JpaRepository<HateBoard,Long> {

    @Query("select u.boardNo from HateBoard u where u.memberNo =:memberNo")
    ArrayList findByBoardNo (Long memberNo);
}
