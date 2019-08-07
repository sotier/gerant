package com.fireflyi.gn.gerant.core.cache.impl;

import com.fireflyi.gn.gerant.core.cache.LocalCacheService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/7
 * DESC Guava Cache（LoadingCache)实现本地缓存
 */
@Singleton
public class LocalGuavaCache implements LocalCacheService<String> {

    private static final Logger log = LoggerFactory.getLogger(LocalGuavaCache.class);

    private Cache<String, String> localCache;

    public LocalGuavaCache(){
        localCache = CacheBuilder.newBuilder()
                        .maximumSize(5000)
                        .expireAfterWrite(-1L, TimeUnit.MINUTES) // 设置缓存永不失效
                        .concurrencyLevel(10) // 设置并发级别为10
                        .recordStats() // 开启缓存统计
                        .build();
    }


    @Override
    public Boolean set(String key,String value) {
        localCache.put(key, value);
        return true;
    }

    @Override
    public String get(String key) {
        try {
            return localCache.get(key, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return null;
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            log.error("e->{}",e.getMessage());
        }
        return null;
    }
}
