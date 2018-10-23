package com.masterchengzi.newsgetserver.common;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsgetserver.server.GetNewsFeign;
import com.masterchengzi.authserver.entity.GetNewsWithBLOBs;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class FeignClientFallBack implements FallbackFactory<GetNewsFeign> {
    @Override
    public GetNewsFeign create(Throwable throwable) {
        return new GetNewsFeign() {
            @Override
            public JsonResult delete(@RequestParam(name = "newsId") String newsId) {
                return new JsonResult(ResultCode.EXCEPTION, "feign_exception_callback: function delete is fail ! ");
            }

            @Override
            public JsonResult insert(@RequestBody List<GetNewsWithBLOBs> record) {
                return new JsonResult(ResultCode.EXCEPTION, "feign_exception_callback: function insert is fail ! ");
            }
        };
    }
}
