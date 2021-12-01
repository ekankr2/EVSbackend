package com.example.heroku.service;

import com.example.heroku.controller.request.MemberRequest;
import com.example.heroku.controller.request.MyCarStateRequest;
import com.example.heroku.controller.request.MyChargingStateRequest;
import com.example.heroku.entity.Member;
import com.example.heroku.entity.MyCarState;
import com.example.heroku.entity.MyChargingState;
import com.example.heroku.entity.MyParkingState;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    public  void memberRegister (Member member) throws  Exception;

    public List<Member> FindById(String email) throws  Exception;

    public Optional<Member> FindBymemberImp(String memberId) throws  Exception;

    public  boolean IdMatchedBirthday (MemberRequest memberRequest) throws  Exception ;

    public List<Member> getMeberList() throws  Exception;

    public void deleteMember (Long memberNo)throws  Exception;

    public Boolean login(MemberRequest memberRequest) throws  Exception ;

    public Long  findByMemberNo(MemberRequest memberRequest) throws  Exception;

    public  String addLikeBoard(Long boardNo,  MemberRequest memberRequest) throws  Exception;

    public  String  addHateBoard (Long boardNo, MemberRequest memberRequest) throws  Exception;

    public  Optional<Member> findByMemberInfo(Long memberNo) throws  Exception ;

    public  void GETMemberAuth (Long memberNo) throws  Exception ;

    public  String getAuth(Long memberNo) throws  Exception;

    public  void IDban (Long memberNo) throws  Exception;

    public  void jailbreak (Long memberNo) throws  Exception ;

    public  String findByMemberStatus(MemberRequest memberRequest) throws  Exception;

    public List<Member> findALLByNo(Long memberNo) throws  Exception;

    public List<Member> findALLByName(String name) throws  Exception;

    public List<Member> findALLById(String memberId) throws  Exception;

    public void delete(Long memberNo) throws Exception;

    public void modify(Long memberNo, MemberRequest memberRequest) throws Exception;

    public String addMyState(Long memberNo, MyChargingStateRequest myChargingStateRequest);

    public List<MyChargingState> findByMemberNo(Long memberNo) throws Exception;

    public void deleteMyState(Long rowNo) throws Exception;

    public  String addMyParkingState(Long memberNo , MyParkingState myParkingState) throws  Exception;

    public List<MyParkingState> getMyParkingState (Long memberNo) throws  Exception;

    public void deleteMyParkingState(Long rowNo) throws Exception;

    public String addMyCar(Long memberNo, MyCarStateRequest myCarStateRequest);

    public List<MyCarState> getMyCarState(Long memberNo) throws Exception;

    public void deleteMyCar(Long rowNo) throws Exception;
}
