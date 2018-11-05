package com.masterchengzi.authserver.security;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FrameworkEndpoint
public class RevokeTokenEndpoint {
	@Autowired
	private ConsumerTokenServices consumerTokenServices;

	@RequestMapping(value = "/oauth/token", method= RequestMethod.DELETE)
	public @ResponseBody
	JsonResult revokeToken(String access_token){
		JsonResult msg = null;
		if (consumerTokenServices.revokeToken(access_token)){
			msg=new JsonResult(ResultCode.SUCCESS,"注销成功");
		}else {
			msg=new JsonResult(ResultCode.FAIL,"注销失败");
		}
		return msg;
	}
}
