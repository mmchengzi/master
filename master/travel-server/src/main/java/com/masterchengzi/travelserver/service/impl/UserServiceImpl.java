package com.masterchengzi.travelserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.common.SnowflakeIdWorker;
import com.masterchengzi.mastercommon.util.CheckCommon;
import com.masterchengzi.travelserver.config.EmailTool;
import com.masterchengzi.travelserver.dao.UserDao;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.qcloudsms.SmsSenderUtil;
import com.masterchengzi.travelserver.qcloudsms.SmsSingleSender;
import com.masterchengzi.travelserver.qcloudsms.SmsSingleSenderResult;
import com.masterchengzi.travelserver.qcloudsms.httpclient.HTTPException;
import com.masterchengzi.travelserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    @Autowired
    private EmailTool emailTool;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Value("${sms.appID}")
    private String appID;
    @Value("${sms.appKey}")
    private String appKey;
    @Value("${sms.templateId}")
    private String templateId;

    @Override
    public JsonResult getList(Integer userId, String username,String openid, String email,String phone, Date beginTime, Date endTime) {
        try {
            List<User> resultList = dao.getList(userId, username, openid, email,phone, beginTime, endTime);
            return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult getPage(Integer userId, String username, String openid,String email,String phone, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> resultList = dao.getList(userId, username, openid,email, phone,beginTime, endTime);
            PageInfo<User> resultPage = new PageInfo<>(resultList);
            return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult delete(Integer userId) {
        try {
            Integer resultList = dao.delete(userId);
            return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult insert(List<User> record) {
        try {
            int ret = 0;
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            if (record != null && record.size() > 0) {
                for (User dto : record) {
                    List<User> rlt = dao.getList(null, dto.getUsername(),null, dto.getEmail(),dto.getPhone(), null, null);
                    if (rlt != null && rlt.size() > 0) continue;
                    dto.setId((int) idWorker.nextId());
                    int r = dao.insert(dto);
                    if (r >= 0) ret += r;
                }
            }
            JsonResult rlt = new JsonResult(ResultCode.SUCCESS, "成功", ret);
            return rlt;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult update(List<User> record) {
        try {
            int ret = 0;
            if (record != null && record.size() > 0) {
                for (User dto : record) {
                    int r = dao.update(dto);
                    if (r >= 0) ret += r;
                }
            }
            return new JsonResult(ResultCode.SUCCESS, "成功", ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult subscrib(String content, String code) {
        try {
            String redisCode = stringRedisTemplate.opsForValue().get(content);
            if (code != null && code.equals(redisCode)) {
                SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
                User u = new User();
                u.setId((int) idWorker.nextId());
                u.setName("游客" + System.currentTimeMillis());
                List<User> user=new ArrayList<>();
                String tag="";
                if (CheckCommon.checkEmail(content)) {
                    tag="邮箱号";
                    u.setEmail(content);
                    user = dao.getList(null, content,null, null,null, null, null);
                } else if (CheckCommon.checkMobileNumber(content)) {
                    tag="手机号";
                    u.setPhone(content);
                    user = dao.getList(null,null,null, content, null, null, null);
                }
                if (user.size() <=0) {
                    int ret = dao.insert(u);
                    return new JsonResult(ResultCode.SUCCESS, "订阅成功", ret);
                } else {
                    return new JsonResult(ResultCode.SUCCESS_IS_HAVE, "该"+tag+"已经注册过了");
                }
            }
            return new JsonResult(ResultCode.FAIL, "验证码不正确或者已经过期");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    @Override
    public JsonResult sendCode(String content) {
        try {
            if (content == null) {
                return new JsonResult(ResultCode.FAIL, "验证不能为空！");
            }
            if (CheckCommon.checkEmail(content)) {
                return this.sendEmail(content);
            } else if (CheckCommon.checkMobileNumber(content)) {
                return this.sendSMS(content);
            }else{
                return new JsonResult(ResultCode.FAIL, "请输入正确的邮箱或者手机号码！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    public JsonResult sendEmail(String email) {
        try {
            String code = String.valueOf(SmsSenderUtil.getRandom());
            stringRedisTemplate.opsForValue().set(email, code, 60 * 2, TimeUnit.SECONDS);
           // String[] filePath = new String[]{"C:\\Users\\zjc\\Desktop\\3.png"};
            Map<String, Object> valueMap = new HashMap<>();
            valueMap.put("to", new String[]{email});
            valueMap.put("title", "注册交友旅游");
            valueMap.put("content", code);
            valueMap.put("filePathList", null);
            emailTool.sendSimpleMail(valueMap);
            return new JsonResult(ResultCode.SUCCESS, "验证码发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCode.FAIL, e.getMessage());
        }
    }

    public JsonResult sendSMS(String phone) {
        SmsSingleSender smsSingleSender = new SmsSingleSender(Integer.parseInt(appID), appKey);
        ArrayList<String> params = new ArrayList<>();
        params.add(String.valueOf(SmsSenderUtil.getRandom()));
        try {
            String code = String.valueOf(SmsSenderUtil.getRandom());
            stringRedisTemplate.opsForValue().set(phone, code, 60 * 2, TimeUnit.SECONDS);
            SmsSingleSenderResult SmsSingleSenderResult = smsSingleSender.sendWithParam("86", phone, Integer.parseInt(templateId), params, null, null, null);
            return new JsonResult(ResultCode.SUCCESS, "验证码发送成功！",SmsSingleSenderResult.toString());
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
