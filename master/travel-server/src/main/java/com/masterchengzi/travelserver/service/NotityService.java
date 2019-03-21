package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface NotityService {

    JsonResult notityEmail(ArrayList<String> emails, String content);

    JsonResult notitySMS(ArrayList<String> phoneNums, String content);
}