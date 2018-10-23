package com.masterchengzi.newsserver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class NewsHot {
    private String newsId;

    private Date time;

    private String image;

    private String remark;

    private String source;

    private String title;

    private String tag;

    private Integer loveTimes;

    private Integer readTimes;

    private Integer commentTimes;
}