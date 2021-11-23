package com.example.heroku.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "charger_list")
@NoArgsConstructor
@Data
public class ChargerList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long chargerNo;

    @Column(nullable = true)
    private String statNm;

    @Column(nullable = true)
    private String statId;

    @Column(nullable = true)
    private String chgertypeList;

    @Column(nullable = true)
    private String addrList;

    @Column(nullable = true)
    private String latList;

    @Column(nullable = true)
    private String lngList;

    @Column(nullable = true)
    private String useTimeList;

    @Column(nullable = true)
    private String busiCallList;

    @Column(nullable = true)
    private String statList;

    @Column(nullable = true)
    private String statUpdDtList;

    @Column(nullable = true)
    private String lastTsdtList;

    @Column(nullable = true)
    private String lastTedtList;

    @Column(nullable = true)
    private String nowTsdtList;

    @Column(nullable = true)
    private String outputList;

    @Column(nullable = true)
    private String zcodeList;

    @Column(nullable = true)
    private String parkingFreeList;
}
