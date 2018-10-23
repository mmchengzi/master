package com.masterchengzi.authserver.model;

import lombok.Data;

@Data
public class OauthClientToken {
    private String authenticationId;

    private String tokenId;

    private String userName;

    private String clientId;

    private byte[] token;
}