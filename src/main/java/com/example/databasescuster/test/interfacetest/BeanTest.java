package com.example.databasescuster.test.interfacetest;

import com.example.databasescuster.test.interfacetest.SayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author cxr
 * @Date 2021/1/24 21:03
 */
@RestController
@RequestMapping("/beanTest")
public class BeanTest {

    @Resource(name="sayServiceMap")
    Map<String, SayService> sayServiceMap;

    @GetMapping("/say")
    public String say(){
        SayService sayOne = sayServiceMap.get("sayOne");
        SayService sayTwo = sayServiceMap.get("sayTwo");

        return sayOne.hello() + "\n" + sayTwo.hello();
    }
}
