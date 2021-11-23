package com.example.heroku.repository;

import com.example.heroku.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberAuthRepository extends JpaRepository<Administrator, Long> {

    @Query("select i.auth from Administrator i where i.memberNo = :memberNo")
    String getAuth(Long memberNo);
}
