package com.masterchengzi.sharesrobot.service.impl;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.sharesrobot.service.StockJuHe;
import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.masterchengzi.mastercommon.util.Net.net;

@Repository
@Log4j2
public class StockJuHeImpl implements StockJuHe {

	@Value("${juhe.PathUrl}")
	private String JuheUrl;
	@Value("${juhe.Key}")
	private String APPKEY;
	@Value("${ifeng.daily}")
	private String daily;
	@Value("${ifeng.aminhis}")
	private String aminhis;
	@Value("${ifeng.KLineData}")
	private String KLineData;
	/**
	 * 每天
	 * @param gid
	 * @return
	 */
	@Override
	public JsonResult getifengAkdaily(String gid) {
		try {
			String url = daily + gid;//请求接口地址
			RestTemplate restT = new RestTemplate();
			String quoteString = restT.getForObject(url, String.class);
			JSONObject object = JSONObject.fromObject(quoteString);
			if (object!=null) {
				return new JsonResult(ResultCode.SUCCESS, "成功", object);
			} else {
				return new JsonResult(ResultCode.FAIL, "失败",object);
			}
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}

	}

	/**
	 * 最近二十天左右的 每5分钟数据
	 *
	 * @param gid
	 * @param scale 5、15、30、60
	 * @param ma    均值 5、10、15、20、25
	 * @param num   返回个数 最大242
	 * @return
	 */
	@Override
	public JsonResult getKLineData(String gid, int scale, int ma, int num) {
		try {
			String url = KLineData + "symbol="+gid+"&scale="+scale+"&ma="+ma+"&datalen="+num;//请求接口地址
			RestTemplate restT = new RestTemplate();
			String quoteString = restT.getForObject(url, String.class);
			JSONArray object = JSONArray.fromObject(quoteString);
			if (object!=null) {
				return new JsonResult(ResultCode.SUCCESS, "成功", object);
			} else {
				return new JsonResult(ResultCode.FAIL, "失败", object);
			}
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	/**
	 * 最近5天 /分钟
	 *
	 * @param gid
	 * @return
	 */
	@Override
	public JsonResult getifengAminhis(String gid) {
		try {
			String url = aminhis + gid;//请求接口地址
			RestTemplate restT = new RestTemplate();
			String quoteString = restT.getForObject(url, String.class);
			JSONArray object = JSONArray.fromObject(quoteString);
			if (object!=null) {
				return new JsonResult(ResultCode.SUCCESS, "成功", object);
			} else {
				return new JsonResult(ResultCode.FAIL, "失败", object);
			}
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	/**
	 * 沪深股市
	 *
	 * @param id
	 * @return
	 */

	@Override
	public JsonResult getStockHS(String id) {
		String result = null;
		String url = JuheUrl + "/hs";//请求接口地址
		Map params = new HashMap();//请求参数
		params.put("gid", id);//股票编号，上海股市以sh开头，深圳股市以sz开头如：sh601009
		params.put("key", APPKEY);//APP Key
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return new JsonResult(ResultCode.SUCCESS, "成功", object.get("result"));
			} else {
				return new JsonResult(ResultCode.FAIL, object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	/**
	 * 香港股市
	 *
	 * @param id
	 * @return
	 */
	@Override
	public JsonResult getStockHK(String id) {
		String result =null;
		String url = JuheUrl + "/hk";//请求接口地址
		Map params = new HashMap();//请求参数
		params.put("num",id);//股票代码，如：00001 为“长江实业”股票代码
		params.put("key",APPKEY);//APP Key

		try {
			result =net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return new JsonResult(ResultCode.SUCCESS, "成功", object.get("result"));
			} else {
				return new JsonResult(ResultCode.FAIL, object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	/**
	 * 美国股市
	 *
	 * @param id
	 * @return
	 */
	@Override
	public JsonResult getStockUSA(String id) {
		String result =null;
		String url = JuheUrl + "/usa";//请求接口地址
		Map params = new HashMap();//请求参数
		params.put("gid",id);//股票代码，如：00001 为“长江实业”股票代码
		params.put("key",APPKEY);//APP Key

		try {
			result =net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return new JsonResult(ResultCode.SUCCESS, "成功", object.get("result"));
			} else {
				return new JsonResult(ResultCode.FAIL, object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}


	/**
	 * 股市列表 香港(hkall) 深圳(szall) 美国(usaall) 沪股(shall)
	 *
	 * @param page
	 * @return
	 */
	@Override
	public JsonResult getStockAll(String page,String tag) {
		String result =null;
		String url = JuheUrl + "/"+tag;//请求接口地址
		Map params = new HashMap();//请求参数
		params.put("key",APPKEY);//您申请的APPKEY
		params.put("page",page);//第几页,每页20条数据,默认第1页

		try {
			result =net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return new JsonResult(ResultCode.SUCCESS, "成功", object.get("result"));
			} else {
				return new JsonResult(ResultCode.FAIL, object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}


	public static void main(String[] args) {
		StockJuHeImpl stockJuHe =new StockJuHeImpl();
		log.info("result::::::::"+stockJuHe.getKLineData("sz300020",5,5,10));
	}
}
