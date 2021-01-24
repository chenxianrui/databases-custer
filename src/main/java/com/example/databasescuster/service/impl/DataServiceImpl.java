package com.example.databasescuster.service.impl;

import com.example.databasescuster.dao.DatabaseDao;
import com.example.databasescuster.databases.ConnectDatabases;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @Author cxr
 * @Date 2021/1/24 18:15
 */
@Slf4j
@Service
public class DataServiceImpl implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public void connect(String type, DatabaseDao databaseDao) throws SQLException {
        ConnectDatabases connectDatabases = (ConnectDatabases) applicationContext.getBean(type+"ConnImpl");
        connectDatabases.connectDb(databaseDao);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
