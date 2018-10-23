package com.masterchengzi.authserver.model;

import lombok.Data;

import java.util.Date;
@Data
public class Role {
    private Integer id;

    private String name;

    private String value;

    private String tips;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}