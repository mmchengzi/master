package com.masterchengzi.authserver.model;

import lombok.Data;

@Data
public class PrivilegeKey {
    private Integer roleId;

    private String menuId;
}