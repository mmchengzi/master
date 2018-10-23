package com.masterchengzi.authserver.model;

import lombok.Data;

@Data
public class OauthCode {
    private String code;

    private byte[] authentication;
}