package com.example.databasescuster.service.impl;

import com.example.databasescuster.dao.DatabaseDao;
import com.example.databasescuster.databases.ConnectDatabases;
import com.example.databasescuster.extension.ExtensionLoader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author cxr
 * @Date 2021/1/22 10:52
 */
@AllArgsConstructor
@Slf4j
public class ConnectServiceImpl {
    private final ConnectDatabases connectDatabases;

    public ConnectServiceImpl() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
        this.connectDatabases = ExtensionLoader.getExtensionLoader(ConnectDatabases.class).getExtension("mysql");
    }

    public void setConnectDatabases(DatabaseDao databases) throws SQLException {
        connectDatabases.connectDb(databases);
    }
}
