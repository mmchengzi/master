package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.NewsComment;

public interface NewsCommentService {
    JsonResult getNewsComment(String newsId);

    JsonResult delete(String newsId);

    JsonResult insert(NewsComment record);

    JsonResult update(NewsComment record);
}