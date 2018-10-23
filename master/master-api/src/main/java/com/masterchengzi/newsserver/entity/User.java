package com.masterchengzi.newsserver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userId;

    private String phone;

    private String name;

    private String passwd;

    private Date time;
}