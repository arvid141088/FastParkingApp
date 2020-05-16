package com.finalyear.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheService {

    public static final String CARPARK_LIST = "CARPARK_LIST";

    private static Map<String, Object> cache = new HashMap<>();


    public static void put(String key, Object object) {

        cache.put(key, object);
    }

    public static <T> T get(String key, Class<T> valueType) {

        return (T) cache.get(key);
    }

    public static <T> List<T> getList(String key, Class<T> valueType) {
        return (List<T>) cache.get(key);
    }

}
