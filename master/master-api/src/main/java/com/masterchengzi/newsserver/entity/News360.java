package com.masterchengzi.newsserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.Date;

@Data
@Log
public class News360 {
    private String publishDate;

    private String likeCount;

    private String publishDateStr;

    private String title;

    private String content;

    private String url;

    private String commentCount;

    private String tags;

    private String shareCount;

    private String posterScreenName;

    private String imageUrls;
    private String id;
}