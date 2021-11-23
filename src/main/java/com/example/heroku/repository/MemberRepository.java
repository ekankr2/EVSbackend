package com.example.heroku.repository;

import com.example.heroku.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select i.memberId from Member i where i.email = :email")
    List FindByUserId(String email);

    @Query("select i from Member i where i.memberId = :memberId")
    Optional<Member> FindBymemberImp(String memberId);

    @Query("select i.memberNo from Member i where i.memberId = :memberId")
    Long findByMemberNo(String memberId);

    @Query("select i.status from Member i where i.memberId = :memberId")
    String findByMemberStatus(String memberId);

    @Transactional
    @Modifying
    @Query("UPDATE Member b set b.status = :status where b.memberNo = :memberNo")
    void IDban(Long memberNo, String status);

    @Transactional
    @Modifying
    @Query("UPDATE Member b set b.status = :status where b.memberNo = :memberNo")
    void jailbreak(Long memberNo, String status);

    @Query("select i from Member i where i.memberNo = :memberNo")
    List<Member> findALLByNo(Long memberNo);

    @Query("select i from Member i where i.name = :name")
    List<Member> findALLByName(String name);

    @Query("select i from Member i where i.memberId = :memberId")
    List<Member> findALLById(String memberId);

    @Transactional
    @Modifying
    @Query("UPDATE Member m set m.name = :name, m.memberCar = :memberCar, m.email = :email, m.memberPw = :memberPw where m.memberNo = :memberNo")
    void modify(Long memberNo, String name, String memberCar, String memberPw, String email);

    @Query("select i from Member i where i.memberId = :memberId")
    Optional<Member> findByUserId(String memberId);

}
