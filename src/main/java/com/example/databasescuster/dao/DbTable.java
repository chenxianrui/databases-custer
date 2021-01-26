package com.example.databasescuster.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author cxr
 * @Date 2021/1/25 10:05
 */
public class DbTable {
    private String tableName;
    private LinkedHashMap<String, String> fieldType;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public LinkedHashMap<String, String> getFieldType() {
        return fieldType;
    }

    public void setFieldType(LinkedHashMap<String, String> fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public String toString() {
        return "DbTable{" +
                "tableName='" + tableName + '\'' +
                ", fieldType=" + fieldType +
                '}';
    }
}
