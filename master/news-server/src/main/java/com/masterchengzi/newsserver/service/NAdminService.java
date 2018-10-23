package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NAdmin;

public interface NAdminService {

	JsonResult getNAdmin(Integer id, String name);

	JsonResult delete(Integer id);

	JsonResult insert(NAdmin record);

	JsonResult update(NAdmin record);
}