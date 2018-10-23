package com.masterchengzi.mastercommon.common;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
*User zjc
*Created with IntelliJ IDEA
*Created on 2018-10-11 14:33
*使用实例 return new JsonResult(ResultCode.SUCCESS,"成功",name);
*/
public class JsonResult {

	private String code;
	private String message;
	private Object data;


	public JsonResult() {
		this.setCode(ResultCode.SUCCESS.val());
		this.setMessage("成功！");
	}

	public JsonResult(ResultCode code) {
		this.setCode(code.val());
		this.setMessage(code.msg());
	}

	public JsonResult(ResultCode code, String message) {
		this.setCode(code.val());
		this.setMessage(message);
	}

	public JsonResult(ResultCode code, String message, Object data) {

		this.setCode(code.val());
		this.setMessage(message);
		this.setData(data);
	}
	@Override
	public String toString() {

		JSONObject json = new JSONObject();
		try {
			json.put("code", code);
			json.put("message", message);
			json.put("data", data);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json.toString();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
