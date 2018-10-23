package com.masterchengzi.newsserver.entity;
import lombok.Data;

@Data
public class NewsMess {
    private String newsId;

    private String tag;

    private Integer readTimes;

    private Integer loveTimes;

    private Integer commentTimes;
}