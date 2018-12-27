package com.masterchengzi.sharesrobot.service;

import com.masterchengzi.mastercommon.common.JsonResult;

public interface StockJuHe {
	/**
	 * 每天
	 * @param gid
	 * @return
	 */
	JsonResult getifengAkdaily(String gid);

	/**
	 * 最近二十天左右的 每5分钟数据
	 * @param gid
	 * @param scale 5、15、30、60
	 * @param ma 均值 5、10、15、20、25
	 * @param  num   返回个数 最大242
	 * @return
	 */
	JsonResult getKLineData(String gid,int scale,int ma,int num);
	/**
	 * 最近5天 /分钟
	 * @param gid
	 * @return
	 */
	JsonResult getifengAminhis(String gid);
	/**
	 * 沪深股市
	 *
	 * @param gid
	 * @return
	 */
	JsonResult getStockHS(String gid);

	/**
	 * 香港股市
	 *
	 * @param gid
	 * @return
	 */
	JsonResult getStockH(String gid);

	/**
	 * 美国股市
	 *
	 * @param gid
	 * @return
	 */
	JsonResult getStockUSA(String gid);

	/**
	 * 股市列表 香港 深圳 美国 沪股
	 *
	 * @param page
	 * @return
	 */
	JsonResult getStockAll(String page, String tag);
}
