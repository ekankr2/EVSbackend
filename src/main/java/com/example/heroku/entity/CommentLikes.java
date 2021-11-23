package com.example.heroku.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CommentLikes")
@NoArgsConstructor
@Data
public class CommentLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long likeNo;

    @Column(nullable = false)
    private Long commentNo;

    @Column(nullable = false)
    private String memberId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    public CommentLikes(Long likeNo, Long commentNo, String memberId){
        this.likeNo = likeNo;
        this.commentNo = commentNo;
        this.memberId = memberId;
    }
}
