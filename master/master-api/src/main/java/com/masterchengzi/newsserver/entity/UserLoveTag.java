package com.masterchengzi.authserver.entity;
import lombok.Data;

@Data
public class UserLoveTag {
    private String userId;

    private String tags;
}