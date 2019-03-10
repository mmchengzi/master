package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;

import java.util.Date;
import java.util.List;

public interface WxService {
    JsonResult login(String jscode);
}