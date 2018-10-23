package com.masterchengzi.authserver.entity;
import lombok.Data;

@Data
public class NewsComment {
    private String newsId;

    private String comment;
}