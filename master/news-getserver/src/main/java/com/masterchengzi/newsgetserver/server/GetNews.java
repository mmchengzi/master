package com.masterchengzi.newsgetserver.server;

import com.masterchengzi.mastercommon.common.JsonResult;

public interface GetNews {
	/**
	 * http://www.idataapi.cn/product/detail/1
	 *
	 * @param kw
	 * @param site qq.com
	 * @return
	 */
	JsonResult get360News(String kw,String pageToken, String site);

	/**
	 * @param kw        关键字
	 * @param beginDate 只有按关键词搜索时该参数生效
	 * @param endDate   只有按关键词搜索时该参数生效
	 * @param city      只有按关键词搜索时该参数生效
	 * @return
	 */
	JsonResult getCCTVNews(String kw, String beginDate, String endDate, String city);

	/**
	 * 类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),
	 * tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
	 *
	 * @param type
	 * @return
	 */
	JsonResult getJuheNews(String type);


}
