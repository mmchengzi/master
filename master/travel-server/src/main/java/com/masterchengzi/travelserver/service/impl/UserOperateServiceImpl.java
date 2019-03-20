package com.masterchengzi.travelserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserOperateServiceImpl implements UserOperateService {
	@Autowired
	private UserOperateDao      dao;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Override
	public JsonResult getList(String openId, Integer itemId,String partnerId,String version, Date beginTime, Date endTime) {
		try {
			List<UserOperate> resultList = dao.getList(openId, itemId,partnerId,version, beginTime, endTime);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getPage(String openId, Integer itemId,String partnerId,String version, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<UserOperate> resultList = dao.getList(openId, itemId,partnerId,version, beginTime, endTime);
			PageInfo<UserOperate> resultPage = new PageInfo<>(resultList);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String openId, Integer itemId,String version) {
		try {
			Integer resultList = dao.delete(openId, itemId,version);
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
					List<UserOperate> rlt = dao.getList(dto.getOpenId(), dto.getItemId(),null,dto.getVersion(), null, null);
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
	public JsonResult signUp(String openid,String sex, String itemId, String version) {
		try {
			String key = "HD活动报名"+String.valueOf(version)+"-"+openid+"*";
			Set<String> keys=stringRedisTemplate.keys(key);
			if(keys!=null&&keys.size()>0){
				stringRedisTemplate.delete(keys);
			}
			JSONObject jsonObject= new JSONObject();
			jsonObject.put("openid",openid);
			jsonObject.put("itemId",itemId);
			jsonObject.put("version",version);
			jsonObject.put("sex",sex);
			stringRedisTemplate.opsForValue().set("HD活动报名"+String.valueOf(version)+"-"+openid+"-"+String.valueOf(itemId), jsonObject.toJSONString());//添加redis
			return new JsonResult(ResultCode.SUCCESS, "报名成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
		}
	}

	@Override
	public JsonResult getRedis(String key) {
		try {
		String result=	stringRedisTemplate.opsForValue().get(key);//添加redis
			return new JsonResult(ResultCode.SUCCESS, "成功",result);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
		}
	}

	@Override
	public JsonResult deleteRedis(String key) {
		try {
			Set<String> keys=stringRedisTemplate.keys(key);
			Long result=0L;
			if(keys!=null&&keys.size()>0){
				result=stringRedisTemplate.delete(keys);
			}
			return new JsonResult(ResultCode.SUCCESS, "成功",result);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
		}
	}
}
