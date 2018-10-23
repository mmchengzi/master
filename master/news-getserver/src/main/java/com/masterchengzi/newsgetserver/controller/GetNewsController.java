package com.masterchengzi.newsgetserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsgetserver.server.GetNews;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@RequestMapping("getNews")
@Api(value = "GetNewsController", description = "获取新闻")
public class GetNewsController {
    @Autowired
    private GetNews getNews;

    /**
     * @param kw
     * @param pageToken
     * @param site
     * @return
     */
    @ApiOperation(value = "360搜索新闻列表")
    @GetMapping("/get360News")
    public JsonResult get360News(@RequestParam(value = "kw", required = false) String kw,
                                 @RequestParam(value = "pageToken", required = false) String pageToken,
                                 @RequestParam(value = "site", required = false) String site) {
        return getNews.get360News(kw, pageToken, site);
    }

    /**
     *
     * @param kw
     * @param beginDate
     * @param endDate
     * @param city
     * @return
     */
    @ApiOperation(value = "cctv搜索新闻列表")
    @GetMapping("/getCCTVNews")
    public JsonResult getCCTVNews(@RequestParam(value = "kw", required = false) String kw,
                                 @RequestParam(value = "beginDate", required = false) String beginDate,
                                 @RequestParam(value = "endDate", required = false) String endDate,
                                  @RequestParam(value = "city", required = false) String city) {
        return getNews.getCCTVNews( kw,  beginDate,  endDate,  city);
    }
}

