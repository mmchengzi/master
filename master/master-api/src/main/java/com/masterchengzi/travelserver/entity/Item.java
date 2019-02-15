package com.masterchengzi.travelserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.Date;
@Data
@Log
public class Item {
    private Integer itemId;
    private String itemName;
    private String type;

    private String content;

    private Date creatTime;

    private Date beginTime;

    private Date endTime;
}