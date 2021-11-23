package com.example.heroku.repository;

import com.example.heroku.entity.MyParkingState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyParkingStateRepository extends JpaRepository<MyParkingState,Long> {

    @Query("select i from MyParkingState i where i.memberNo = :memberNo")
    List<MyParkingState> findByMemberall (Long memberNo);

}
