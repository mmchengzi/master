package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.util.FileUtils;
import com.masterchengzi.travelserver.service.TenCentService;
import com.qcloud.cos.model.PutObjectRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@RequestMapping("tenCent")
@Api(value = "TenCentController", description = "腾讯接口")
@Log4j
public class TenCentController {
	@Autowired
	private TenCentService service;


	@ApiOperation(value = "文件上传")
	@PostMapping("/upload")
	public JsonResult uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) {
		try {
			String name = "";
			for (MultipartFile mf : files) {
				if (!mf.isEmpty()) {
					File file = FileUtils.multipartFileToFile(mf);
					name = file.getName();
					PutObjectRequest putObjectRequest = new PutObjectRequest("test-1252407640", file.getName(), file);
					JsonResult result = service.fileUpload(putObjectRequest);
				}
			}
			return new JsonResult(ResultCode.SUCCESS, "成功", "https://test-1252407640.cos.ap-guangzhou.myqcloud.com/"+name);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
	@ApiOperation(value = "文件删除")
	@GetMapping("/delete")
	public JsonResult deleteFile(@RequestParam(value = "key", required = false) String key) {
		try {
			service.delete("test-1252407640",key);
			return new JsonResult(ResultCode.SUCCESS, "成功", key);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}