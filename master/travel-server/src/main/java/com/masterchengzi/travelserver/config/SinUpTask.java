package com.masterchengzi.travelserver.config;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.UserOperate;
import com.masterchengzi.travelserver.service.UserOperateService;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 报名任务
 */
@Component
@Log4j2
public class SinUpTask {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private UserOperateService  userOperateService;

	@Scheduled(cron = "0 0 12 ? * FRI")  // 每周四中午
	public void lineUp() {
		try {
			Set<String> keys = stringRedisTemplate.keys("HD活动报名*");
			Iterator<String> it = keys.iterator();
			List<Item> items = new ArrayList<>();
			List<UserOperate> userMan = new ArrayList<>();
			List<UserOperate> userWoman = new ArrayList<>();
			while (it.hasNext()) {
				String value = stringRedisTemplate.opsForValue().get(it.next());
				JSONObject json = new JSONObject(value);
				String openid = json.getString("openid");
				Integer itemId = json.getInt("itemId");
				String version = json.getString("version");
				String sex = json.getString("sex");
				Item item = new Item();
				item.setItemId(itemId);
				item.setVersion(version);
				items.add(item);//所有活动
				UserOperate userOperate = new UserOperate();
				userOperate.setOpenId(openid);
				userOperate.setItemId(itemId);
				userOperate.setVersion(version);
				if ("男".equals(sex)) {
					userOperate.setEvaluate("男");
					userMan.add(userOperate);
				} else {
					userOperate.setEvaluate("女");
					userWoman.add(userOperate);
				}

			}
			removeDuplicate(items);//去重复
			List<UserOperate> insertDto = new ArrayList<>();
			//分组
			for (Item item : items) {
				List<UserOperate> resultUser = new ArrayList<>();
				int i = 0;
				for (UserOperate userOperate : userMan) {//男生分组
					if (item.getItemId().equals(userOperate.getItemId()) && item.getVersion().equals(userOperate.getVersion())) {
						int y = (int) Math.ceil(1 / 10);
						userOperate.setTag(String.valueOf(y + 1));
						resultUser.add(userOperate);
						i++;
					}
				}
				i = 0;
				for (UserOperate userOperate : userWoman) {//女生分组
					if (item.getItemId().equals(userOperate.getItemId()) && item.getVersion().equals(userOperate.getVersion())) {
						int y = (int) Math.ceil(1 / 10);
						userOperate.setTag(String.valueOf(y + 1));
						resultUser.add(userOperate);
						i++;
					}
				}
				for (UserOperate user : resultUser) {
					for (UserOperate user1 : resultUser) {
						if (user.getPartnerId() == null && user1.getPartnerId() == null && !user.getEvaluate().equals(user1.getEvaluate())) {
							user.setPartnerId(user1.getOpenId());
							user1.setPartnerId(user.getOpenId());
							insertDto.add(user);
							insertDto.add(user1);
						}
					}
				}
			}
			//resultUser 判断是否有partnerid==null 报名失败 微信公众行好提醒
			JsonResult result = userOperateService.insert(insertDto);
			log.info("人员分配成：" + result);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("人员分配失败 系统异常");
		}
	}

	//去重
	public static List<Item> removeDuplicate(List<Item> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getItemId().equals(list.get(i).getItemId()) && list.get(j).getVersion().equals(list.get(i).getVersion())) {
					list.remove(j);
				}
			}
		}
		return list;
	}
}