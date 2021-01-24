package com.example.databasescuster.test.interfacetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cxr
 * @Date 2021/1/24 21:02
 */
@Component
public class MapConfig {

    @Resource(name = "sayOne")
    private SayService sayOne;

    @Autowired
    @Qualifier("sayTwo")
    private SayService sayTwo;

    @Bean("sayServiceMap")
    public Map<String, SayService> geneSayServiceMap(){
        Map<String, SayService> sayServiceMap = new HashMap<>();
        sayServiceMap.put("sayOne", sayOne);
        sayServiceMap.put("sayTwo", sayTwo);
        return sayServiceMap;
    }
}
