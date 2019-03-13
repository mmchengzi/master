package com.masterchengzi.travelserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.Date;
@Data
@Log
public class UserOperate extends UserOperateKey {
    private String evaluate;

    private String tag;
    private Integer partnerId;
    private String version;
    private Date createTime;
}