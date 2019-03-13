package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.PutObjectRequest;

import java.io.File;

/**
 * 腾讯的相关接口开发
 */
public interface TenCentService {
    JsonResult fileUpload(final PutObjectRequest putObjectRequest);
    JsonResult download(final GetObjectRequest GetObjectRequest, final File file);
}