package com.masterchengzi.travelserver.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

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
			String key = stringRedisTemplate.opsForValue().get("HD活动报名*");
			Set<String> keys = stringRedisTemplate.keys(key);
			if (keys != null && keys.size() > 0) {
				stringRedisTemplate.delete(keys);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}