package com.example.heroku.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class HateBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_no")
    private  Long rowNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private  Long boardNo;

    public  HateBoard (Long memberNo, Long boardNo) {

        this.memberNo = memberNo;
        this.boardNo = boardNo;

    }
}
