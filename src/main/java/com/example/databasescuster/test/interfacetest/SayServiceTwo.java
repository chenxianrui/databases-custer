package com.example.databasescuster.test.interfacetest;

import org.springframework.stereotype.Service;

/**
 * @Author cxr
 * @Date 2021/1/24 21:02
 */
@Service("sayTwo")
public class SayServiceTwo implements SayService {
    @Override
    public String hello() {
        System.out.println("say two");
        return "say two";
    }
}
