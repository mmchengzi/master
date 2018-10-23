package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NewsComment;

public interface NewsCommentService {
    JsonResult getNewsComment(String newsId);

    JsonResult delete(String newsId);

    JsonResult insert(NewsComment record);

    JsonResult update(NewsComment record);
}