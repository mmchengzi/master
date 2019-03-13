package com.masterchengzi.travelserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Log
public class Item {
    private Integer    itemId;
    private String     itemName;
    private Integer    userId;
    private Integer    parentId;
    private String     type;
    private BigDecimal price;
    private String     content;
    private String     version;
    private Date creatTime;

    private Date beginTime;

    private Date endTime;
}