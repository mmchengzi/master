package com.masterchengzi.newsserver.config;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.myDate;
import com.masterchengzi.newsserver.service.GetNewsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Log4j2
public class ScheduledTask {
	@Autowired
	private GetNewsService getNewsService;
	//定时删除两天前的数据

	@Scheduled(cron = "0 0 0 * * ?")  // 每天凌晨
	public void getJuheNewsTop() {
		JsonResult result = getNewsService.delete(null, null, null, null, new Date(118, 0, 1), myDate.getdate(new Date(), -2));
		log.info(result.getMessage() + "删除两天前的数据:" + result.getData());
	}

}