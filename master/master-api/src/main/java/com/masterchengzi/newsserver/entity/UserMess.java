package com.masterchengzi.authserver.entity;
import lombok.Data;

@Data
public class UserMess {
    private String userId;

    private Integer sex;

    private Integer age;

    private String email;

    private String address;

    private String image;

    private Integer isPrivate;
}