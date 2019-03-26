package com.masterchengzi.travelserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.common.SnowflakeIdWorker;
import com.masterchengzi.travelserver.dao.NewDao;
import com.masterchengzi.travelserver.dao.UserDao;
import com.masterchengzi.travelserver.entity.New;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class NewServiceImpl implements NewService {
	@Autowired
	private NewDao  dao;
	@Autowired
	private UserDao userDao;

	@Override
	public JsonResult getList(Integer newId, Integer parentId, String openId, String tag, Date beginTime, Date endTime) {
		try {
			List<New> list = dao.getList(null, null, null, "2", null, null);
			List<User> userList = userDao.getList(null, null, null, null, null, null, null);
			List<New> resultList = dao.getList(newId, parentId, openId, tag, beginTime, endTime);
			for (New n : resultList) {
				n.setUser(this.getUser(userList, n.getOpenId()));
				n.setComment(this.getComment(userList,list, String.valueOf(n.getNewId())));
				if(n.getImages()!=null){
					n.setImagesList(Arrays.asList(n.getImages().split(",")));
				}
				n.setImages(null);
			}
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getPage(Integer newId, Integer parentId, String openId, String tag, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<New> list = dao.getList(null, null, null, "2", null, null);
			List<User> userList = userDao.getList(null, null, null, null, null, null, null);
			List<New> resultList = dao.getList(newId, parentId, openId, tag, beginTime, endTime);
			for (New n : resultList) {
				n.setUser(this.getUser(userList, n.getOpenId()));
				n.setComment(this.getComment(userList,list, String.valueOf(n.getNewId())));
				if(n.getImages()!=null){
					n.setImagesList(Arrays.asList(n.getImages().split(",")));
				}
				n.setImages(null);
			}
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

	public User getUser(List<User> userList, String openid) {

		User user = new User();
		if (openid == null) {
			return null;
		}
		if (userList != null) {
			for (User u : userList) {
				if (openid.equals(u.getOpenid())) {
					user = u;
					break;
				}
			}
		}
		return user;
	}

	public List<New> getComment(List<User> userList,List<New> list, String newsid) {
		if (newsid == null) {
			return null;
		}
		List<New> newsList = new ArrayList<>();
		if (list != null) {
			for (New n : list) {
				if (newsid.equals(String.valueOf(n.getParentId()))) {
					List<New> news1 = getComment(userList,list, String.valueOf(n.getNewId()));
					n.setComment(news1);
					n.setUser(this.getUser(userList,n.getOpenId()));
					newsList.add(n);
				}
			}
		}

		return newsList;
	}

}
