package com.masterchengzi.travelserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.Date;
@Data
@Log
public class User {
    private Integer id;

    private String avatar;

    private String username;

    private String password;

    private String salt;

    private String name;

    private String birthday;

    private String sex;

    private String email;

    private String phone;

    private String status;

    private Date createTime;

    private Date updateTime;
}