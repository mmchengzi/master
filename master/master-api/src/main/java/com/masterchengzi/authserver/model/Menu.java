package com.masterchengzi.authserver.model;

import lombok.Data;

import java.util.Date;
@Data
public class Menu {
    private String id;

    private String code;

    private String pCode;

    private String pId;

    private String name;

    private String url;

    private Integer isMenu;

    private Integer level;

    private Integer sort;

    private Integer status;

    private String icon;

    private Date createTime;

    private Date updateTime;
}