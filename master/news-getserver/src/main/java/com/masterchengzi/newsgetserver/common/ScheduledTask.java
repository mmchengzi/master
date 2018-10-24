package com.masterchengzi.newsgetserver.common;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsgetserver.server.GetNews;
import com.masterchengzi.newsgetserver.server.GetNewsFeign;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Log4j2
public class ScheduledTask {
	@Autowired
	private GetNews getNews;

	@Autowired
	private GetNewsFeign getNewsFeign;

	//@Scheduled(fixedRate = 5000)
	public void get360News() {
		try {
			JsonResult jsonResult = getNews.get360News("明星", null, "qq.com");
			if ("200".equals(jsonResult.getCode())) {
				String str = jsonResult.getData().toString();
				JSONObject myJsonObject = new JSONObject(str);
				if (myJsonObject.get("retcode").equals("000000")) {
					log.info(myJsonObject);
					JSONArray data = myJsonObject.getJSONArray("data");
					List<GetNewsWithBLOBs> newsWithBLOBsList = new ArrayList<>();
					for (int i = 0; i < data.length(); i++) {
						GetNewsWithBLOBs newsWithBLOBs = new GetNewsWithBLOBs();
						JSONObject job = data.getJSONObject(i);
						newsWithBLOBs.setNewsLink(job.getString("url"));
						newsWithBLOBs.setSource(job.getString("posterScreenName"));
						newsWithBLOBs.setTime(new Date());
						newsWithBLOBs.setImage(job.get("imageUrls").toString());
						newsWithBLOBs.setTitle(job.getString("title"));
						newsWithBLOBs.setTextContent(job.getString("content"));
						newsWithBLOBsList.add(newsWithBLOBs);
					}
					log.info("开始上传：" + newsWithBLOBsList.size());
					JsonResult result = getNewsFeign.insert(newsWithBLOBsList);
					log.info("成功上传新闻数：" + result.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Scheduled(cron = "0 0/20 8-23 * * ?")  // 15*3 45
	public void getJuheNewsTop() {
		getNews.getJuheNews("top");
	}
	@Scheduled(cron = "0 0/30 8-22 * * ?")  // 14*2 28
	public void getJuheNews1() {
		getNews.getJuheNews("guonei");
		getNews.getJuheNews("guoji");
		getNews.getJuheNews("keji");
		getNews.getJuheNews("yule");
	}
	@Scheduled(cron = "0 0/40 8-22 * * ?")  // 9*1.5 12
	public void getJuheNews2() {
		getNews.getJuheNews("shehui");
		getNews.getJuheNews("junshi");
	}
	@Scheduled(cron = "0 0/59 9-18 * * ?")  // 7*1 6  2
	public void getJuheNews3() {
		getNews.getJuheNews("tiyu");
		getNews.getJuheNews("caijing");
		getNews.getJuheNews("shishang");

	}


}