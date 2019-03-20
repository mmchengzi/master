package com.masterchengzi.travelserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Date;
@Data
@Log
public class New {
    private Integer newId;

    private Integer parentId;

    private String openId;

    private String content;

    private String images;

    private String tag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;
}