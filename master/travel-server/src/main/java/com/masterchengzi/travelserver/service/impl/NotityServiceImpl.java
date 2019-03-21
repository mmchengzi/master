package com.masterchengzi.travelserver.service.impl;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.travelserver.config.EmailTool;
import com.masterchengzi.travelserver.qcloudsms.SmsMultiSender;
import com.masterchengzi.travelserver.qcloudsms.SmsMultiSenderResult;
import com.masterchengzi.travelserver.qcloudsms.SmsSenderUtil;
import com.masterchengzi.travelserver.qcloudsms.httpclient.HTTPException;
import com.masterchengzi.travelserver.service.NotityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotityServiceImpl implements NotityService {
	@Autowired
	private EmailTool emailTool;
	@Value("${sms.appID}")
	private String    appID;
	@Value("${sms.appKey}")
	private String    appKey;
	@Value("${sms.multiTemplateId}")
	private String    multiTemplateId;

	@Override
	public JsonResult notityEmail(Map<String, String> map) {
		try {
			if (!map.containsKey("emails")) {
				return new JsonResult(ResultCode.FAIL, "邮箱不能为空！");
			}
			if (!map.containsKey("addr")) {
				return new JsonResult(ResultCode.FAIL, "地点内容不能为空！");
			}
			if (!map.containsKey("time")) {
				return new JsonResult(ResultCode.FAIL, "时间内容不能为空！");
			}
			ArrayList<String> emails = new ArrayList(Arrays.asList(map.get("emails").toString().split(",")));
			String addr = map.get("addr").toString();
			String time = map.get("time").toString();

			Map<String, Object> valueMap = new HashMap<>();
			valueMap.put("title", "交友旅游活动通知");
			valueMap.put("content", "【交友旅游】感谢您报名参加交友旅游举办的活动，请及时于"+time+"前，在"+addr+"集合,欢迎参加本次活动。");
			valueMap.put("filePathList", null);
			for (String email : emails) {
				valueMap.put("to", new String[]{email});
				emailTool.sendSimpleMail(valueMap);
			}
			return new JsonResult(ResultCode.SUCCESS, "活动通知发送成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult notitySMS(Map<String, String> map) {
		try {
			if (!map.containsKey("phoneNums")) {
				return new JsonResult(ResultCode.FAIL, "电话号码不能为空！");
			}
			if (!map.containsKey("addr")) {
				return new JsonResult(ResultCode.FAIL, "地点内容不能为空！");
			}
			if (!map.containsKey("time")) {
				return new JsonResult(ResultCode.FAIL, "时间内容不能为空！");
			}
			ArrayList<String> phoneNums = new ArrayList(Arrays.asList(map.get("phoneNums").toString().split(",")));
			String addr = map.get("addr").toString();
			String time = map.get("time").toString();
			if (phoneNums == null || phoneNums.size() <= 0) {
				return new JsonResult(ResultCode.FAIL, "电话号码不能为空！");
			}
			if (addr == null || addr.length() <= 0) {
				return new JsonResult(ResultCode.FAIL, "地点内容不能为空！");
			}
			if (time == null || time.length() <= 0) {
				return new JsonResult(ResultCode.FAIL, "时间内容不能为空！");
			}
			SmsMultiSender smsMultiSender = new SmsMultiSender(Integer.parseInt(appID), appKey);
			ArrayList<String> params = new ArrayList<>();
			params.add(time);
			params.add(addr);
			SmsMultiSenderResult smsMultiSenderResult = smsMultiSender.sendWithParam("86", phoneNums, Integer.parseInt(multiTemplateId), params, null, null, null);
			return new JsonResult(ResultCode.SUCCESS, "通知发送成功！", smsMultiSenderResult.toString());
		} catch (HTTPException e) {
			e.printStackTrace();
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
