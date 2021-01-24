package com.example.databasescuster.test.interfacetest;

import org.springframework.stereotype.Service;

/**
 * @Author cxr
 * @Date 2021/1/24 21:02
 */
@Service("sayOne")
public class SayServiceOne implements SayService {
    @Override
    public String hello() {
        System.out.println("say one");
        return "say one";
    }
}
