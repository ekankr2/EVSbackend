package com.example.heroku.repository;

import com.example.heroku.entity.MyChargingState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyChargingStateRepository extends JpaRepository<MyChargingState,Long> {

    @Query("select i from MyChargingState i where i.memberNo = :memberNo")
    List<MyChargingState> findByMemberall (Long memberNo);

    List<MyChargingState> findByMemberNo(Long memberNo);



    //////////// 종자 ///////////
    //List<MyChargingState> deleteById(Long memberNo);

}
