package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.service.UserService;
import com.masterchengzi.travelserver.service.WxService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(value = "UserController", description = "用户信息")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private WxService wxService;

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/getList")
    public JsonResult getList(@RequestParam(value = "userId", required = false) Integer userId,
                              @RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "openid", required = false) String openid,
                              @RequestParam(value = "email", required = false) String email,
                              @RequestParam(value = "phone", required = false) String phone,
                              @RequestParam(value = "beginTime", required = false) Date beginTime,
                              @RequestParam(value = "endTime", required = false) Date endTime) {
        return service.getList(userId, username, openid,email, phone, beginTime, endTime);
    }

    @ApiOperation(value = "分页查询用户")
    @GetMapping("/getPage")
    public JsonResult getPageNews(@RequestParam(value = "userId", required = false) Integer userId,
                                  @RequestParam(value = "username", required = false) String username,
                                  @RequestParam(value = "openid", required = false) String openid,
                                  @RequestParam(value = "email", required = false) String email,
                                  @RequestParam(value = "phone", required = false) String phone,
                                  @RequestParam(value = "beginTime", required = false) Date beginTime,
                                  @RequestParam(value = "endTime", required = false) Date endTime,
                                  @RequestParam(name = "pageNum", required = false) int pageNum,
                                  @RequestParam(name = "pageSize", required = false) int pageSize) {
        return service.getPage(userId, username,openid, email, phone, beginTime, endTime, pageNum, pageSize);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete")
    public JsonResult delete(@RequestParam(name = "userId") Integer userId,
                             @RequestParam(name = "openid") String openid) {
        return service.delete(userId,openid);
    }

    @ResponseBody
    @ApiOperation(value = "新增用户")
    @PostMapping("/insert")
    public JsonResult insert(@ApiParam(value = "List<User>") @RequestBody List<User> record) {
        return service.insert(record);
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/update")
    public JsonResult update(@ApiParam(value = "List<Item>") @RequestBody List<User> record) {
        return service.update(record);
    }

    @ApiOperation(value = "邮件订阅")
    @PostMapping("/subscrib")
    public JsonResult subscrib(@RequestParam(value = "content", required = false) String content,
                               @RequestParam(value = "code", required = false) String code) {
        return service.subscrib(content, code);
    }

    @ApiOperation(value = "发送验证码")
    @PostMapping("/sendCode")
    public JsonResult sendCode(@RequestParam(value = "content", required = false) String content) {
        return service.sendCode(content);
    }

    @ApiOperation(value = "微信登陆")
    @GetMapping("/wxlogin")
    public JsonResult wxlogin(@RequestParam(value = "code", required = false) String code) {
        return wxService.login(code);
    }

}
