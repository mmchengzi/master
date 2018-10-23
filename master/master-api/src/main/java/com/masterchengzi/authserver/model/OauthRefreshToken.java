package com.masterchengzi.authserver.model;

import lombok.Data;

@Data
public class OauthRefreshToken {
    private String tokenId;

    private byte[] token;

    private byte[] authentication;
}