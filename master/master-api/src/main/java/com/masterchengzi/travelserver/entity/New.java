package com.masterchengzi.travelserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.List;

@Data
@Log
public class New {
    private Integer newId;

    private Integer parentId;

    private String openId;
    private User user;
    private String content;

    private String images;
    private List<String> imagesList;
    private String    tag;
    private List<New> comment;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;
}