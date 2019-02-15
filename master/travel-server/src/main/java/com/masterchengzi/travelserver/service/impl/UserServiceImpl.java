package com.masterchengzi.travelserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.common.SnowflakeIdWorker;
import com.masterchengzi.travelserver.dao.UserDao;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public JsonResult getList(Integer userId, String username, Date beginTime, Date endTime) {
		try {
			List<User> resultList = dao.getList(userId, username, beginTime, endTime);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getPage(Integer userId, String username, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<User> resultList = dao.getList(userId, username, beginTime, endTime);
			PageInfo<User> resultPage = new PageInfo<>(resultList);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(Integer userId) {
		try {
			Integer resultList = dao.delete(userId);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(List<User> record) {
		try {
			int ret = 0;
			SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
			if (record != null && record.size() > 0) {
				for (User dto : record) {
					List<User> rlt = dao.getList(null, dto.getUsername(), null, null);
					if (rlt != null && rlt.size() > 0) continue;
					dto.setId((int) idWorker.nextId());
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
	public JsonResult update(List<User> record) {
		try {
			int ret = 0;
			if (record != null && record.size() > 0) {
				for (User dto : record) {
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
