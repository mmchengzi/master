package com.masterchengzi.travelserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.util.Date;

@Data
@Log
public class User implements Serializable {
    private static final long serialVersionUID = 8453093936749210817L;
    private Integer id;

    private String avatar;

    private String username;

    private String password;
    private String openid;
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