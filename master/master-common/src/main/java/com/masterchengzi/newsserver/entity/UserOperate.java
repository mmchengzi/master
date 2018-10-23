package com.masterchengzi.authserver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserOperate {
    private String userId;

    private String newsId;

    private String comment;

    private Date time;

    private Integer isLove;
}