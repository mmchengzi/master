package com.masterchengzi.sharesrobot.config;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.myDate;
import com.masterchengzi.sharesrobot.service.StockJuHe;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Log4j2
public class ScheduledTask {
	@Autowired
	StockJuHe stockJuHe;

/*	@Scheduled(cron="0/5 * *  * * ? ")
	public void getJuheNews1() {
		stockJuHe.getStockHS("sz300020");
	}*/

}