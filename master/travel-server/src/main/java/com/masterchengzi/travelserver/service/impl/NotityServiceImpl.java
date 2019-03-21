package com.masterchengzi.travelserver.service.impl;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.travelserver.config.EmailTool;
import com.masterchengzi.travelserver.qcloudsms.*;
import com.masterchengzi.travelserver.qcloudsms.httpclient.HTTPException;
import com.masterchengzi.travelserver.service.NotityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class NotityServiceImpl implements NotityService {
	@Autowired
	private EmailTool emailTool;
	@Value("${sms.appID}")
	private String appID;
	@Value("${sms.appKey}")
	private String appKey;
	@Value("${sms.multiTemplateId}")
	private String multiTemplateId;
	@Override
	public JsonResult notityEmail(ArrayList<String> emails, String content) {
		try {
			String code = String.valueOf(SmsSenderUtil.getRandom());
			Map<String, Object> valueMap = new HashMap<>();
			valueMap.put("title", "交友旅游活动通知");
			valueMap.put("content", "【交友旅游】感谢您报名参加"+content);
			valueMap.put("filePathList", null );
			for(String email:emails){
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
	public JsonResult notitySMS(ArrayList<String> phoneNums, String content) {
		if(phoneNums==null||phoneNums.size()<=0){
			return new JsonResult(ResultCode.FAIL, "电话号码不能为空！");
		}
		if(content==null||content.length()<=0){
			return new JsonResult(ResultCode.FAIL, "短信内容不能为空！");
		}
		SmsMultiSender smsMultiSender = new SmsMultiSender(Integer.parseInt(appID), appKey);
		ArrayList<String> params = new ArrayList<>();
		params.add(content);
		try {
			String code = String.valueOf(SmsSenderUtil.getRandom());
			SmsMultiSenderResult smsMultiSenderResult = smsMultiSender.sendWithParam("86", phoneNums, Integer.parseInt(multiTemplateId), params, null, null, null);
			return new JsonResult(ResultCode.SUCCESS, "通知发送成功！",smsMultiSenderResult.toString());
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
