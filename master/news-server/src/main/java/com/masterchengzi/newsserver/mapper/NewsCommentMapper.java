package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.entity.NAdmin;
import com.masterchengzi.authserver.entity.NewsComment;
import com.masterchengzi.authserver.entity.NewsFeedback;

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