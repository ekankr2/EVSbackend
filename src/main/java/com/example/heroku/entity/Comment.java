package com.example.heroku.entity;

import com.example.heroku.controller.request.CommentRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Comment")
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long commentNo;

    @Column(nullable = true)
    private Long boardNo;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "commentNo")
    private Set<CommentLikes> commentLikes = new HashSet<CommentLikes>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "commentNo")
    private Set<CommentReply> commentReply = new HashSet<CommentReply>();



    public Comment(Long boardNo, String memberId, String content){
        this.boardNo = boardNo;
        this.memberId = memberId;
        this.content = content;
    }

    public void updateComment(CommentRequest commentRequest){
        this.memberId = commentRequest.getMemberId();
        this.content = commentRequest.getContent();
    }

    public void deleteComment(CommentRequest commentRequest){
        this.memberId = commentRequest.getMemberId();
        this.isDeleted = commentRequest.getIsDeleted();
    }
}
