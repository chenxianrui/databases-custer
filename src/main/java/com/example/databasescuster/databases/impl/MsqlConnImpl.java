package com.example.databasescuster.databases.impl;

import com.example.databasescuster.dao.DatabaseDao;
import com.example.databasescuster.dao.DbTable;
import com.example.databasescuster.databases.ConnectDatabases;
import com.example.databasescuster.drivers.DbDrivers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author cxr
 * @Date 2021/1/22 10:08
 */
@Slf4j
@Service("mysql")
public class MsqlConnImpl implements ConnectDatabases {

    private static String URL = " ";

    static {
        try {
            Class.forName(DbDrivers.MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            log.debug("MySQL驱动加载失败");
        }
    }

    @Override
    public synchronized String connectDb(DatabaseDao databaseDao) throws SQLException {
        URL = "jdbc:mysql://" +
                databaseDao.getIp() +
                ":" +
                databaseDao.getPort() +
                "/" +
                databaseDao.getDatabaseName() +
                "?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
        try {
            Connection conn = DriverManager.getConnection(URL, databaseDao.getUsername(), databaseDao.getPassword());
            log.info("ip：" + databaseDao.getIp() +
                    ", port: " + databaseDao.getPort() +
                    ", database: " + databaseDao.getDatabaseName() +
                    " 连接成功");
        }catch (Exception e){
            log.debug("ip：" + databaseDao.getIp() +
                    ", port: " + databaseDao.getPort() +
                    ", database: " + databaseDao.getDatabaseName() +
                    " 连接失败");
        }
        return "连接成功";
    }

    @Override
    public void createTable(DbTable dbTable) {

    }
}
