package com.project.hibernate.config.redis;


import java.util.List;

public interface BaseRedis<T> {
    void add(String key, Long time, T object);

    void add(String key, Long time, List<T> objects);

    T get(String key, Class<T> tClass);

    List<T> getList(String key);

    void delete(String key);
}