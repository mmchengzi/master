package com.masterchengzi.newsserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.Date;

@Data
@Log
public class GetNews {
    private String newsId;

    private String newsLink;

    private String source;

    private Date time;

    private String title;

    private String headline;

    private String tag;

    private String image;

    private String video;

    private String keyword;

    private Integer isOld;
}