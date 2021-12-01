package com.example.heroku.repository;

import com.example.heroku.entity.MyCarState;
import com.example.heroku.entity.MyChargingState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyCarStateRepository extends JpaRepository<MyCarState,Long> {

    @Query("select i from MyCarState i where i.memberNo = :memberNo")
    List<MyCarState> findByMemberall (Long memberNo);


}
