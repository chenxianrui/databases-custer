package com.example.databasescuster.controller;

/**
 * @Author cxr
 * @Date 2021/1/22 9:27
 */
import com.example.databasescuster.dao.DatabaseDao;
import com.example.databasescuster.dao.DbTable;
import com.example.databasescuster.databases.ConnectDatabases;
import com.example.databasescuster.service.impl.ConnectServiceImpl;
import com.example.databasescuster.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/start")
public class StratController {

    @Resource(name = "dbMap")
    Map<String, ConnectDatabases> connectDatabasesMap;

    @RequestMapping("/springboot")
    public String startSpringBoot() throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
        DatabaseDao databaseDao = new DatabaseDao();
        databaseDao.setDatabaseName("blog");
        databaseDao.setIp("localhost");
        databaseDao.setPassword("123qwe");
        databaseDao.setPort("3306");
        databaseDao.setUsername("root");
//        connectService.setConnectDatabases(databaseDao);
        ConnectDatabases connectDatabases = connectDatabasesMap.get("mysql");
        connectDatabases.connectDb(databaseDao);

        DatabaseDao databaseDao1 = new DatabaseDao();
        databaseDao1.setDatabaseName("blog");
        databaseDao1.setIp("192.168.20.93");
        databaseDao1.setPassword("");
        databaseDao1.setPort("4333");
        databaseDao1.setUsername("root");
//        connectService.setConnectDatabases(databaseDao);
        ConnectDatabases connectDatabases1 = connectDatabasesMap.get("rapids");
        connectDatabases1.connectDb(databaseDao1);
        DbTable dbTable = new DbTable();
        dbTable.setTableName("TPCHTEST.kkk");
        connectDatabases1.createTable(dbTable);

        return "Welcome to the world of Spring Boot!";
    }
}
