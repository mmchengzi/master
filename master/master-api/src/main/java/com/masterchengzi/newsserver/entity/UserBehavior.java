package com.masterchengzi.newsserver.entity;
import lombok.Data;

@Data
public class UserBehavior {
    private String userId;

    private String newsId;

    private String newsTag;

    private Integer behaviorType;

    private Double weight;

    private Integer isComment;

    private String address;

    private Integer newsWay;

    private String age;

    private Integer score;

    private Integer times;
}