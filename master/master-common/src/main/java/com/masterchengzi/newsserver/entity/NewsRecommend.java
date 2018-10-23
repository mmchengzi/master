package com.masterchengzi.authserver.entity;
import lombok.Data;

@Data
public class NewsRecommend {
    private String userId;

    private String newsScore;
}