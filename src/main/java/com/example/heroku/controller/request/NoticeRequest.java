package com.example.heroku.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class NoticeRequest {
    private String title;
    private String content;
    private String img;


}
