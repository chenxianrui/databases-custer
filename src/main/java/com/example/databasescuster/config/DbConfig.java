package com.example.databasescuster.config;

import com.example.databasescuster.databases.ConnectDatabases;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cxr
 * @Date 2021/1/24 21:22
 */
@Component
public class DbConfig {
    @Resource(name = "mysql")
    private ConnectDatabases mysqlConnect;

    @Bean("dbMap")
    public Map<String, ConnectDatabases> dbMap(){
        Map<String, ConnectDatabases> dbMaps = new HashMap<>();
        dbMaps.put("mysql", mysqlConnect);
        return dbMaps;
    }
}
