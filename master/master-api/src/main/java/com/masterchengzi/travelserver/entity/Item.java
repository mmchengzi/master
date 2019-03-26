package com.masterchengzi.travelserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String     images;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date creatTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endTime;
}