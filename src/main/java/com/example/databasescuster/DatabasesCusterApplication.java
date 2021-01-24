package com.example.databasescuster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DatabasesCusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabasesCusterApplication.class, args);
    }

}
