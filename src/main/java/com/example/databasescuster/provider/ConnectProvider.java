package com.example.databasescuster.provider;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author cxr
 * @Date 2021/1/28 23:18
 * 存储与获取 Connection 对象
 */
@Slf4j
public class ConnectProvider {
    private Map<String, Connection> connectionMap;

    public ConnectProvider(){
        connectionMap = new ConcurrentHashMap<>();
    }

    public Connection get(String key){
        if (connectionMap.containsKey(key)){
            Connection connection = connectionMap.get(key);
            if (connection != null)
                return connection;
        }
        // 如果没有连接，则建立连接

        return null;
    }

    public void set(String key, Connection connection){
        connectionMap.put(key, connection);
    }

    public void remove(String key){
        connectionMap.remove(key);
        log.info("当前数据库连接数：[{}]",connectionMap.size());
    }
}
