package com.masterchengzi.travelserver.sms.httpApiDemo;

import com.masterchengzi.travelserver.sms.httpApiDemo.common.HttpUtil;
import org.springframework.beans.factory.annotation.Value;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS{

	@Value("${sms.ACCOUNT_SID}")
	private String       accountSid;
	@Value("${sms.BASE_URL}")
	private String       baseurl;

	private  String operation = "/industrySMS/sendSMS";

	private  String to = "1361305****";
	private  String smsContent = "【秒嘀科技】您的验证码是345678，30分钟输入有效。";

	/**
	 * 验证码通知短信
	 */
	public  void execute()
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = baseurl + operation;
		HttpUtil httpUtil=new HttpUtil();
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        +  httpUtil.createCommonParam();

	    // 提交请求
	    String result = httpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}
