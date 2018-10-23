package com.masterchengzi.authserver.model;

import lombok.Data;

import java.util.Date;
@Data
public class Privilege extends PrivilegeKey {
    private Date createTime;
}