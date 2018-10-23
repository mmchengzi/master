package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.NewsComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface NewsCommentDao {
    List<NewsComment> getNewsComment(String newsId);

    int delete(String newsId);

    int insert(NewsComment record);

    int update(NewsComment record);
}