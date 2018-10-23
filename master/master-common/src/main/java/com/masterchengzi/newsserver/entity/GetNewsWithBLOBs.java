package com.masterchengzi.authserver.entity;
import lombok.Data;

@Data
public class GetNewsWithBLOBs extends GetNews {
    private String textContent;

    private String htmlContent;
}