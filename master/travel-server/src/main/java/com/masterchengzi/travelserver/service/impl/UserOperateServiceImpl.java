package com.masterchengzi.travelserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.travelserver.dao.UserOperateDao;
import com.masterchengzi.travelserver.entity.UserOperate;
import com.masterchengzi.travelserver.service.UserOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class UserOperateServiceImpl implements UserOperateService {
	@Autowired
	private UserOperateDao      dao;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Override
	public JsonResult getList(Integer userId, Integer itemId,Integer partnerId,String version, Date beginTime, Date endTime) {
		try {
			List<UserOperate> resultList = dao.getList(userId, itemId,partnerId,version, beginTime, endTime);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getPage(Integer userId, Integer itemId,Integer partnerId,String version, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<UserOperate> resultList = dao.getList(userId, itemId,partnerId,version, beginTime, endTime);
			PageInfo<UserOperate> resultPage = new PageInfo<>(resultList);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(Integer userId, Integer itemId,String version) {
		try {
			Integer resultList = dao.delete(userId, itemId,version);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(List<UserOperate> record) {
		try {
			int ret = 0;
			if (record != null && record.size() > 0) {
				for (UserOperate dto : record) {
					List<UserOperate> rlt = dao.getList(dto.getUserId(), dto.getItemId(),null,dto.getVersion(), null, null);
					if (rlt != null && rlt.size() > 0) continue;
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
	public JsonResult update(List<UserOperate> record) {
		try {
			int ret = 0;
			if (record != null && record.size() > 0) {
				for (UserOperate dto : record) {
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

	@Override
	public JsonResult signUp(Integer userId, Integer itemId, String version) {
		try {
			String key = stringRedisTemplate.opsForValue().get("HD活动报名"+String.valueOf(version)+"-"+userId+"*");
			Set<String> keys=stringRedisTemplate.keys(key);
			if(keys!=null&&keys.size()>0){
				stringRedisTemplate.delete(keys);
			}
			stringRedisTemplate.opsForValue().set("HD活动报名"+String.valueOf(version)+"-"+userId+"-"+String.valueOf(itemId), String.valueOf(userId));//添加redis
			return new JsonResult(ResultCode.SUCCESS, "报名成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
		}
	}
}
