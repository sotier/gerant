package com.fireflyi.gn.gerant.core.cache;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/22
 * DESC TODO
 */
@Singleton
public class RedisClient{

    @Inject
    RedisClientProvider redisPool;

    public String get(String key){
        return redisPool.getResource().get(key);
    }

}
