package com.example.databasescuster.dao;

import java.util.HashMap;

/**
 * @Author cxr
 * @Date 2021/1/22 9:56
 */
public class Results {
    private String table;   // 表名
    private HashMap<String, String> fieldAndVal;    // 字段名与数据

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public HashMap<String, String> getFieldAndVal() {
        return fieldAndVal;
    }

    public void setFieldAndVal(HashMap<String, String> fieldAndVal) {
        this.fieldAndVal = fieldAndVal;
    }
}
