package com.masterchengzi.travelserver.service.impl;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.travelserver.service.TenCentService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Download;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TenCentServiceImpl implements TenCentService {
	@Value("${wx.SecretId}")
	private String SecretId  = "AKID2wsjOrlwDHFG5CFJblQ5bvPsHTgloNsD";
	@Value("${wx.SecretKey}")
	private String SecretKey = "MbdS8g2DORIxPktpeMsCKLAnFVYaaUOB";
	@Value("${wx.APPID}")
	private String APPID     = "1252407640";

	@Override
	public JsonResult fileUpload(final PutObjectRequest putObjectRequest) {
		TransferManager transferManager=null;
		try {
			// 1 初始化用户身份信息（secretId, secretKey）。
			COSCredentials cred = new BasicCOSCredentials(SecretId, SecretKey);
// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
			ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
// 3 生成 cos 客户端。
			COSClient cosClient = new COSClient(cred, clientConfig);
			// 线程池大小，建议在客户端与COS网络充足(如使用腾讯云的CVM，同园区上传COS)的情况下，设置成16或32即可, 可较充分的利用网络资源
// 对于使用公网传输且网络带宽质量不高的情况，建议减小该值，避免因网速过慢，造成请求超时。
			ExecutorService threadPool = Executors.newFixedThreadPool(32);
			// 传入一个 threadpool, 若不传入线程池, 默认 TransferManager 中会生成一个单线程的线程池。
			 transferManager = new TransferManager(cosClient, threadPool);
// 本地文件上传
			Upload upload = transferManager.upload(putObjectRequest);
			// 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
			UploadResult uploadResult = upload.waitForUploadResult();
			// 关闭 TransferManger
			transferManager.shutdownNow();
			return new JsonResult(ResultCode.SUCCESS, "成功", uploadResult);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
		}finally {
			// 关闭 TransferManger
			transferManager.shutdownNow();
		}
	}

	@Override
	public JsonResult download(final GetObjectRequest GetObjectRequest, final File file) {
		try {
			// 1 初始化用户身份信息（secretId, secretKey）。
			COSCredentials cred = new BasicCOSCredentials(SecretId, SecretKey);
// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
			ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
// 3 生成 cos 客户端。
			COSClient cosClient = new COSClient(cred, clientConfig);


			// 线程池大小，建议在客户端与COS网络充足(如使用腾讯云的CVM，同园区上传COS)的情况下，设置成16或32即可, 可较充分的利用网络资源
// 对于使用公网传输且网络带宽质量不高的情况，建议减小该值，避免因网速过慢，造成请求超时。
			ExecutorService threadPool = Executors.newFixedThreadPool(32);
			// 传入一个 threadpool, 若不传入线程池, 默认 TransferManager 中会生成一个单线程的线程池。
			TransferManager transferManager = new TransferManager(cosClient, threadPool);
// 本地文件上传
			// 下载文件
			Download download = transferManager.download(GetObjectRequest, file);
			// 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
			try {
				download.waitForCompletion();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 关闭 TransferManger
			transferManager.shutdownNow();
			return new JsonResult(ResultCode.SUCCESS, "下载成功");
		} catch (CosServiceException e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String bucketname, String key) {
		try {
			// 1 初始化用户身份信息（secretId, secretKey）。
			COSCredentials cred = new BasicCOSCredentials(SecretId, SecretKey);
// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
			ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
// 3 生成 cos 客户端。
			COSClient cosClient = new COSClient(cred, clientConfig);
			cosClient.deleteObject(bucketname, key);
			return new JsonResult(ResultCode.SUCCESS, "删除成功");
		} catch (CosServiceException e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION, e.getMessage());
		}
	}

	public static void main(String[] args) {
		TenCentServiceImpl tenCentService=new TenCentServiceImpl();
		//上传
		//PutObjectRequest putObjectRequest=new PutObjectRequest("test-1252407640","x.jpg",new File("C:\\Users\\Administrator\\Desktop\\x.jpg"));
		//tenCentService.fileUpload(putObjectRequest);
        //下载
		File f=new File("C:/Users/Administrator/Desktop/down.jpg");
		GetObjectRequest getObjectRequest=new GetObjectRequest("test-1252407640","x.jpg");
		tenCentService.download(getObjectRequest,f);
	}
}
