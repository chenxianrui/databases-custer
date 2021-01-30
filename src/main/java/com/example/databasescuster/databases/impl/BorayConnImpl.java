package com.example.databasescuster.databases.impl;

import com.example.databasescuster.dao.DatabaseDao;
import com.example.databasescuster.dao.DbTable;
import com.example.databasescuster.databases.ConnectDatabases;
import com.example.databasescuster.drivers.DbDrivers;
import com.example.databasescuster.factory.SingletonFactory;
import com.example.databasescuster.provider.ConnectProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.*;

/**
 * @Author cxr
 * @Date 2021/1/25 9:23
 */
@Slf4j
@Service("rapids")
public class BorayConnImpl implements ConnectDatabases {

    private static String URL = " ";
    private static String SQL = " ";
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ConnectProvider connectProvider;
    private static String key = " ";

    public BorayConnImpl(){
        connectProvider = SingletonFactory.getInstance(ConnectProvider.class);
    }

    static {
        try {
            Class.forName(DbDrivers.RAPIDSDB_DRIVER);
        }catch (ClassNotFoundException e){
            log.debug("Rapids驱动加载失败");
        }
    }

    @Override
    public synchronized String connectDb(DatabaseDao databaseDao) throws SQLException {
        key = "rapids:"+databaseDao.getIp()+databaseDao.getPort();
        URL = "jdbc:rdp://" +
                databaseDao.getIp() +
                ":" +
                databaseDao.getPort();
        try {
            conn = DriverManager.getConnection(URL, databaseDao.getUsername(), databaseDao.getPassword());
            connectProvider.set(key, conn);
            log.info("ip：" + databaseDao.getIp() +
                    ", port: " + databaseDao.getPort() +
                    " 连接成功");
        }catch (Exception e){
            log.debug("ip：" + databaseDao.getIp() +
                    ", port: " + databaseDao.getPort() +
                    " 连接失败");
        }
        return "连接成功";
    }

    @Override
    public synchronized void createTable(DbTable dbTable) {
        SQL = "CREATE TABLE " + dbTable.getTableName()+"( id INTEGER,NAME varchar(1), CREATE_TIME timestamp)";
        try {
            System.out.println("--");
            conn.prepareStatement(SQL).execute();
            System.out.println("--");
            Statement statement = conn.createStatement();
            System.out.println("---");
            statement.execute("use connector tpchtest;");
            System.out.println("----");
            statement.execute(SQL);
            System.out.println("-----");
            log.info("创建表 " + dbTable.getTableName() + " 成功");
        } catch (SQLException throwables) {
            log.debug("创建表 " + dbTable.getTableName() + " 失败");
        }
    }
}
