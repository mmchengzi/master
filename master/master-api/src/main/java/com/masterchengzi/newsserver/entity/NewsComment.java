package com.masterchengzi.newsserver.entity;
import lombok.Data;

@Data
public class NewsComment {
    private String newsId;

    private String comment;
}