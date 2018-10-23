package com.masterchengzi.authserver.model;

import java.util.Date;

public class Privilege extends PrivilegeKey {
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}