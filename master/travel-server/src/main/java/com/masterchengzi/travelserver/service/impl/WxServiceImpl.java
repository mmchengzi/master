package com.masterchengzi.travelserver.service.impl;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.util.HttpUtils;
import com.masterchengzi.travelserver.service.WxService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WxServiceImpl implements WxService {
    public static final String URL = "https://api.weixin.qq.com/sns/jscode2session?";
    @Value("${wx.smp-Appid}")
    private String APPID;
    @Value("${wx.smp-AppSecret}")
    private String SECRET;

    @Override
    public JsonResult login(String jscode) {
        String url = URL + "appid=" + APPID + "&secret=" + SECRET + "&js_code=" + jscode + "&grant_type=authorization_code";
        try {
            JSONObject jsonObject = HttpUtils.getRequestFromUrl(url);
            String openid = jsonObject.getString("openid");
            String session_key = jsonObject.getString("session_key");
            String unionid = jsonObject.getString("unionid");
            int errcode = jsonObject.getInt("errcode");
            String errmsg = jsonObject.getString("errmsg");
            return new JsonResult(ResultCode.SUCCESS, "成功", jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }
}
