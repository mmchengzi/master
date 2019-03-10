package com.masterchengzi.travelserver;

import com.masterchengzi.travelserver.config.EmailTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailToolTest {
    @Autowired
    private EmailTool emailTool;

    @Test
    public void sendSimpleMail() {

        String[] filePath = new String[]{"C:\\Users\\zjc\\Desktop\\3.png"};

        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("to", new String[]{"1173727598@qq.com", "97441358@qq.com"});
        valueMap.put("title", "测试标题");
        valueMap.put("content", "测试内容");
        valueMap.put("filePathList", filePath);
        emailTool.sendSimpleMail(valueMap);
    }
}

