package com.masterchengzi.travelserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.common.SnowflakeIdWorker;
import com.masterchengzi.travelserver.dao.NewDao;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.New;
import com.masterchengzi.travelserver.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class NewServiceImpl implements NewService {
    @Autowired
    private NewDao dao;
    @Override
    public JsonResult getList(Integer newId, Integer parentId, String openId, Date beginTime, Date endTime) {
        try {
            List<New> resultList = dao.getList(newId, parentId, openId, beginTime, endTime);
            return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult getPage(Integer newId, Integer parentId, String openId, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<New> resultList = dao.getList(newId, parentId, openId, beginTime, endTime);
            PageInfo<New> resultPage = new PageInfo<>(resultList);
            return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult delete(Integer newId, Integer parentId, String openId) {
        try {
            Integer resultList = dao.delete(newId, parentId, openId);
            return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult insert(List<New> record) {
        try {
            int ret = 0;
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            if (record != null && record.size() > 0) {
                for (New dto : record) {
                    dto.setNewId((int) idWorker.nextId());
                    int r = dao.insert(dto);
                    if (r >= 0) ret += r;
                }
            }
            JsonResult rlt = new JsonResult(ResultCode.SUCCESS, "成功", ret);
            return rlt;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult update(List<New> record) {
        try {
            int ret = 0;
            if (record != null && record.size() > 0) {
                for (New dto : record) {
                    int r = dao.update(dto);
                    if (r >= 0) ret += r;
                }
            }
            return new JsonResult(ResultCode.SUCCESS, "成功", ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }
}
