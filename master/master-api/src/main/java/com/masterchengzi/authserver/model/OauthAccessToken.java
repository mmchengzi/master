package com.masterchengzi.authserver.model;

import lombok.Data;

@Data
public class OauthAccessToken {
    private String authenticationId;

    private String tokenId;

    private String userName;

    private String clientId;

    private String refreshToken;
}