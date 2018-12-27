package com.masterchengzi.sharesrobot;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.util.HttpUtils;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.masterchengzi.mastercommon.util.Net.net;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SharesRobotApplicationTests {

	@Test
	public void contextLoads() {
		String result =null;
		String url = "http://api.finance.ifeng.com/akdaily/?code=sh601989&type=last";//请求接口地址
		Map params = new HashMap();//请求参数

		try {
			RestTemplate restT = new RestTemplate();
			//通过Jackson JSON processing library直接将返回值绑定到对象
		//	Quote quote = restT.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			String quoteString = restT.getForObject(url, String.class);
			System.out.println(quoteString);

		} catch (Exception e) {
			e.printStackTrace();
			log.info( e.getMessage());
		}
	}

}

