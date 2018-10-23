package com.masterchengzi.newsserver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class NewsFeedback {
    private String userId;

    private String feedback;

    private Date gettime;

    private String reply;

    private Date replytime;

    private Integer isreply;
}