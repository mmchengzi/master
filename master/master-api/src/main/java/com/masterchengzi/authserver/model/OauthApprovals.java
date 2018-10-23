package com.masterchengzi.authserver.model;

import lombok.Data;

import java.util.Date;
@Data
public class OauthApprovals {
    private String userid;

    private String clientid;

    private String scope;

    private String status;

    private Date expiresat;

    private Date lastmodifiedat;
}