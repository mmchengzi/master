package com.masterchengzi.newsgetserver.server.impl;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsgetserver.common.HttpUtils;
import com.masterchengzi.newsgetserver.server.GetNews;
import com.masterchengzi.newsgetserver.server.GetNewsFeign;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
@Log4j2
public class GetNewsImpl implements GetNews {

	@Value("${idataapi.Url360}")
	private String       Url360;
	@Value("${idataapi.cctvUrl}")
	private String       cctvUrl;
	@Value("${juhe.PathUrl}")
	private String       JuheUrl;
	@Autowired
	private GetNewsFeign getNewsFeign;

	/**
	 * @param kw
	 * @param pageToken
	 * @param site
	 * @return
	 */
	@Override
	public JsonResult get360News(String kw, String pageToken, String site) {

		try {
			StringBuffer url = new StringBuffer();
			url.append(Url360);
			if (kw != null && kw.length() > 0) {
				url.append("&kw=" + kw);
			}
			if (pageToken != null && pageToken.length() > 0) {
				url.append("&pageToken=" + pageToken);
			}
			if (site != null && site.length() > 0) {
				url.append("&site=" + site);
			}
			JSONObject json = HttpUtils.getRequestFromUrl(url.toString());
			if (json.has("data")) {
				return new JsonResult(ResultCode.SUCCESS, "成功", json.getJSONArray("data").toList());
			} else {
				return new JsonResult(ResultCode.FAIL, "没有查到信息");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	/**
	 * 查询并插入
	 *
	 * @param kw
	 * @param pageToken
	 * @param site
	 */
	@Override
	public void insert360News(String kw, String pageToken, String site) {
		try {
			JsonResult jsonResult = this.get360News(kw, pageToken, site);
			if ("200".equals(jsonResult.getCode())) {
				List<GetNewsWithBLOBs> newsWithBLOBsList = new ArrayList<>();
				List<JSONObject> datalist = (List<JSONObject>) jsonResult.getData();
				for (int i = 0; i < datalist.size(); i++) {
					GetNewsWithBLOBs newsWithBLOBs = new GetNewsWithBLOBs();
					Map<String, String> job = (Map<String, String>) datalist.get(i);
					List imgs = Collections.singletonList(job.get("imageUrls"));
					StringBuffer images = new StringBuffer();
					List<String> list= (List<String>) imgs.get(0);
					if(list!=null){
						for(String img:list){
							images.append(img.toString());
							images.append(",");
						}
					}
					String dateStr=job.get("publishDateStr");
					dateStr=dateStr.replace("T"," ");
					SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					newsWithBLOBs.setNewsLink(job.get("url"));
					newsWithBLOBs.setSource(job.get("posterScreenName"));
					newsWithBLOBs.setTime(sDateFormat.parse(dateStr));
					newsWithBLOBs.setImage(images.toString());
					newsWithBLOBs.setTitle(job.get("title"));
					newsWithBLOBs.setTextContent(job.get("content"));
					newsWithBLOBs.setTag(site);
					newsWithBLOBsList.add(newsWithBLOBs);
				}
				log.info("开始上传_" + site + ":" + newsWithBLOBsList.size());
				JsonResult result = getNewsFeign.insert(newsWithBLOBsList);
				log.info("上传成功_" + site + result.getData() + "_条新闻_" + result.getMessage());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param kw        关键字
	 * @param beginDate 只有按关键词搜索时该参数生效
	 * @param endDate   只有按关键词搜索时该参数生效
	 * @param city      只有按关键词搜索时该参数生效
	 * @return
	 */
	@Override
	public JsonResult getCCTVNews(String kw, String beginDate, String endDate, String city) {
		try {
			StringBuffer url = new StringBuffer();
			url.append(cctvUrl);
			if (kw != null && kw.length() > 0) {
				url.append("&kw=" + kw);
			}
			if (beginDate != null && beginDate.length() > 0) {
				url.append("&beginDate=" + beginDate);
			}
			if (endDate != null && endDate.length() > 0) {
				url.append("&endDate=" + endDate);
			}
			if (city != null && city.length() > 0) {
				url.append("&city=" + city);
			}
			JSONObject json = HttpUtils.getRequestFromUrl(url.toString());
			if (json.has("data")) {
				return new JsonResult(ResultCode.SUCCESS, "成功", json.getJSONArray("data").toList());
			} else {
				return new JsonResult(ResultCode.FAIL, "没有查到信息");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getJuheNews(String type) {
		try {
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //加上时间
			String url = JuheUrl + type;
			JSONObject json = HttpUtils.getRequestFromUrl(url);
			if (json.get("result").toString().equals("null")) {
				log.error(type + "_超过请求次数");
				return new JsonResult(ResultCode.FAIL, type + "_超过请求次数");
			}
			JSONObject jsonObject = json.getJSONObject("result");
			if (jsonObject.get("stat").equals("1")) {
				JSONArray data = jsonObject.getJSONArray("data");
				List<GetNewsWithBLOBs> newsWithBLOBsList = new ArrayList<>();
				for (int i = 0; i < data.length(); i++) {
					GetNewsWithBLOBs newsWithBLOBs = new GetNewsWithBLOBs();
					JSONObject job = data.getJSONObject(i);
					StringBuffer images = new StringBuffer();
					if (job.has("thumbnail_pic_s")) {
						images.append(job.get("thumbnail_pic_s").toString());
						images.append(",");
					}
					if (job.has("thumbnail_pic_s02")) {
						images.append(job.get("thumbnail_pic_s02").toString());
						images.append(",");
					}
					if (job.has("thumbnail_pic_s03")) {
						images.append(job.get("thumbnail_pic_s03").toString());
					}
					Date date = sDateFormat.parse(job.getString("date"));
					newsWithBLOBs.setNewsLink(job.getString("url"));
					newsWithBLOBs.setSource(job.getString("author_name"));
					newsWithBLOBs.setTime(date);
					newsWithBLOBs.setImage(images.toString());
					newsWithBLOBs.setTitle(job.getString("title"));
					newsWithBLOBs.setTextContent(job.getString("title"));
					newsWithBLOBs.setTag(type);
					newsWithBLOBsList.add(newsWithBLOBs);
				}
				log.info("开始上传_" + type + ":" + newsWithBLOBsList.size());
				JsonResult result = getNewsFeign.insert(newsWithBLOBsList);
				log.info("上传成功_" + type + result.getData() + "_条新闻_" + result.getMessage());
			}
			return new JsonResult(ResultCode.SUCCESS, "成功", json);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
