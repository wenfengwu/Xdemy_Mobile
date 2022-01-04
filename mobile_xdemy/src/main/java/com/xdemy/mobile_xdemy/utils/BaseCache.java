package com.xdemy.mobile_xdemy.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BaseCache {

    //ten minutes cache
    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            //initial case size
            .initialCapacity(10)
            //max size
            .maximumSize(100)
            //num of concurrency
            .concurrencyLevel(5)
            //expire time 10 mins
            .expireAfterWrite(600, TimeUnit.SECONDS)
            //count cache accuracy
            .recordStats()
            //build cache
            .build();

    //one hour cache
    private Cache<String, Object> oneHourCache = CacheBuilder.newBuilder()
            //initial case size
            .initialCapacity(20)
            //max size
            .maximumSize(200)
            //num of concurrency
            .concurrencyLevel(10)
            //expire time 60 mins
            .expireAfterWrite(3600, TimeUnit.SECONDS)
            //count cache accuracy
            .recordStats()
            //build cache
            .build();

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }

    public Cache<String, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }
}
