package com.masterchengzi.travelserver.entity;

import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log
public class UserOperateKey {
    private Integer userId;

    private Integer itemId;
}