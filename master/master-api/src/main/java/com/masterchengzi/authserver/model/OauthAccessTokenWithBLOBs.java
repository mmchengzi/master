package com.masterchengzi.authserver.model;

import lombok.Data;

@Data
public class OauthAccessTokenWithBLOBs extends OauthAccessToken {
    private byte[] token;

    private byte[] authentication;
}