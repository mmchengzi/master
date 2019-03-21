package com.masterchengzi.travelserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.common.SnowflakeIdWorker;
import com.masterchengzi.mastercommon.util.HttpUtils;
import com.masterchengzi.travelserver.dao.UserDao;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.service.WxService;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WxServiceImpl implements WxService {
    public static final String URL = "https://api.weixin.qq.com/sns/jscode2session?";
    @Value("${wx.smp-Appid}")
    private String APPID;
    @Value("${wx.smp-AppSecret}")
    private String SECRET;
    @Autowired
    private UserDao dao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public JsonResult login(String jscode) {
        String url = URL + "appid=" + APPID + "&secret=" + SECRET + "&js_code=" + jscode + "&grant_type=authorization_code";
        try {
            JSONObject jsonObject = HttpUtils.getRequestFromUrl(url);
            String openid = jsonObject.getString("openid");
            String sessionkey = jsonObject.getString("session_key");
            if(StringUtils.isEmpty(sessionkey)||StringUtils.isEmpty(openid)){
                return new JsonResult(ResultCode.INVALID_AUTHCODE, "jscode无效！");
            }else{
                List<User> user= dao.getList(null, null, openid,null,null, null,null);
                User u=new User();
                if(user !=null&&user.size()>0){
                     u=user.get(0);
                }else{
                    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
                    u.setId((int) idWorker.nextId());
                    u.setName("游客"+ System.currentTimeMillis());
                    u.setOpenid(openid);
                    dao.insert(u);
                }
              String token= DigestUtils.sha1Hex(openid+u.getId()+sessionkey);
              stringRedisTemplate.opsForValue().set(token, JSON.toJSONString(u), 1, TimeUnit.HOURS);//添加redis
                JSONObject js = new JSONObject();
                js.put("openid", openid);
                js.put("token", token);
                return new JsonResult(ResultCode.SUCCESS, "成功",   js.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
        }
    }
}
