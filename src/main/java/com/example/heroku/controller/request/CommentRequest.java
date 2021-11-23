package com.example.heroku.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class CommentRequest {
    private Long boardNo;
    private String memberId;
    private String content;
    private Boolean isDeleted;
}
