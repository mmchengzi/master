package com.masterchengzi.newsgetserver.common;

import com.masterchengzi.newsgetserver.server.GetNews;
import com.masterchengzi.newsgetserver.server.GetNewsFeign;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ScheduledTask {
	@Autowired
	private GetNews getNews;
 private String[] strArray={"qq.com","163.com","sina.com.cn","ifeng.com","sohu.com","baidu.com",
		 "cctv.com"};

	@Scheduled(cron = "0 0/30 9-22 * * ?")//9-22 每半个小时
	public void insert360News1() {
		for(String site:strArray){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getNews.insert360News("娱乐", null, site);
		}
	}


	@Scheduled(cron = "0 0/20 9-22 * * ?")  // 14*3 42
	public void getJuheNewsTop() {
		getNews.getJuheNews("top");
	}

	@Scheduled(cron = "0 0/30 9-22 * * ?")  // 13*2 26
	public void getJuheNews1() {
		getNews.getJuheNews("guonei");
		getNews.getJuheNews("guoji");
		getNews.getJuheNews("keji");
		getNews.getJuheNews("yule");
	}

	@Scheduled(cron = "0 0/40 9-22 * * ?")  // 14*1.5 21
	public void getJuheNews2() {
		getNews.getJuheNews("shehui");
		getNews.getJuheNews("junshi");
	}

	@Scheduled(cron = "0 0/59 9-17 * * ?")  // 9*1  9
	public void getJuheNews3() {
		getNews.getJuheNews("tiyu");
		getNews.getJuheNews("caijing");
		getNews.getJuheNews("shishang");

	}


}