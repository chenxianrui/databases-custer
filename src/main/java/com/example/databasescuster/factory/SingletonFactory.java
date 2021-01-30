package com.example.databasescuster.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author cxr
 * @Date 2021/1/30 14:11
 * 单例工厂
 */
public class SingletonFactory {
    private static final Map<String, Object> OBJECT_MAP = new HashMap<>();

    private SingletonFactory(){

    }

    public static <T> T getInstance(Class<T> c){
        String key = c.toString();
        Object instance = null;
        if (instance == null){
            // 加锁
            synchronized (SingletonFactory.class){
                instance = OBJECT_MAP.get(key);
                if (instance == null) {
                    try {
                        // 获取对象
                        instance = c.getDeclaredConstructor().newInstance();
                        // 存储
                        OBJECT_MAP.put(key, instance);
                    } catch (IllegalAccessException | InstantiationException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    } catch (NoSuchMethodException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return c.cast(instance);
    }
}
