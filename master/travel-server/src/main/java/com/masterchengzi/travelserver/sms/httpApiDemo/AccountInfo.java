package com.masterchengzi.travelserver.sms.httpApiDemo;

import com.masterchengzi.travelserver.sms.httpApiDemo.common.HttpUtil;
import org.springframework.beans.factory.annotation.Value;

/**
 * 获取开发者账号信息接口调用示例
 * 
 * @ClassName: AccountInfo
 * @Description: 获取开发者账号信息接口调用示例
 *
 */
public class AccountInfo
{
	@Value("${sms.ACCOUNT_SID}")
	private  String       accountSid;
	@Value("${sms.BASE_URL}")
	private String       baseurl;
	private static String operation = "/query/accountInfo";


	/**
	 * 获取开发者账号信息
	 */
	public  void execute()
	{
		String url = baseurl + operation;
		HttpUtil  httpUtil=new HttpUtil();
		String body = "accountSid=" + accountSid + httpUtil.createCommonParam();

		// 提交请求
		String result = httpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}
}
