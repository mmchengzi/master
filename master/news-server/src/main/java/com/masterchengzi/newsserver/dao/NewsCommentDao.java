package com.masterchengzi.newsserver.dao;


import com.masterchengzi.newsserver.entity.NewsComment;

import java.util.List;

public interface NewsCommentDao {
    List<NewsComment> getNewsComment(String newsId);

    int delete(String newsId);

    int insert(NewsComment record);

    int update(NewsComment record);
}