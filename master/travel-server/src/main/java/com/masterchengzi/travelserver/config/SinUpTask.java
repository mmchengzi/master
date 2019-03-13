package com.masterchengzi.travelserver.config;

import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.UserOperate;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 报名任务
 */
@Component
@Log4j2
public class SinUpTask {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@Scheduled(cron = "0 0 12 ? * FRI")  // 每周四中午
	public void lineUp() {
		try {
			Set<String> keys = stringRedisTemplate.keys("HD活动报名*");
			Iterator<String> it = keys.iterator();
			List<Item> items = new ArrayList<>();
			List<UserOperate> userMan = new ArrayList<>();
			List<UserOperate> userWoman = new ArrayList<>();
			Map<String, Object> map = new HashMap();
		/*	map.put("userId",userId);
			map.put("itemId",itemId);
			map.put("version",version);
			map.put("sex",sex);*/
			while (it.hasNext()) {
				String value = stringRedisTemplate.opsForValue().get(it.next());
				JSONObject json = new JSONObject(value);
				Integer userId = json.getInt("userId");
				Integer itemId = json.getInt("itemId");
				String version = json.getString("version");
				String sex = json.getString("sex");
				Item item = new Item();
				item.setItemId(itemId);
				item.setVersion(version);
				items.add(item);//所有活动
				UserOperate userOperate = new UserOperate();
				userOperate.setUserId(userId);
				userOperate.setItemId(itemId);
				userOperate.setVersion(version);
				if ("男".equals(sex)) {
					userMan.add(userOperate);
				} else {
					userWoman.add(userOperate);
				}

			}
			removeDuplicate(items);//去重复
			List<UserOperate> result = new ArrayList<>();
			for (UserOperate man : userMan) {
				for (UserOperate woman : userWoman) {
					if (woman.getTag() == null) {
						man.setPartnerId(woman.getUserId());
						woman.setPartnerId(man.getUserId());
						man.setTag("1");
						woman.setTag("1");
						result.add(man);
						result.add(woman);
					}
				}
			}
			//分组
			for (Item item : items) {
				List<UserOperate> resultUser=new ArrayList<>();
				int i=0;
				for (UserOperate userOperate : result) {
					if (item.getItemId().equals(userOperate.getItemId()) && item.getVersion().equals(userOperate.getVersion())) {
						int y= (int) Math.ceil(1/10);
						userOperate.setTag(String .valueOf(y+1));
						resultUser.add(userOperate);
						i++;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

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