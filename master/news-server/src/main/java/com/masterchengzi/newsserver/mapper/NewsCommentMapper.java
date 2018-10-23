package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.NAdmin;
import com.masterchengzi.newsserver.entity.NewsComment;
import com.masterchengzi.newsserver.entity.NewsFeedback;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCommentMapper {
    List<NewsComment> getNewsComment(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(NewsComment record);

    int update(NewsComment record);
}