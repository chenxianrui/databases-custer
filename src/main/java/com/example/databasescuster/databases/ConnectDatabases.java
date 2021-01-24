package com.example.databasescuster.databases;

import com.example.databasescuster.dao.DatabaseDao;
import com.example.databasescuster.dao.Results;
import com.example.databasescuster.extension.SPI;

import java.sql.SQLException;

/**
 * @Author cxr
 * @Date 2021/1/22 9:46
 */
@SPI
public interface ConnectDatabases {

    /**
     * 连接数据库
     * @param databaseDao 数据库实体类
     * @return
     */
    String connectDb(DatabaseDao databaseDao) throws SQLException;

}
