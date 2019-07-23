package com.fireflyi.gn.gerant.core.cache;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/22
 * DESC TODO
 */
@Singleton
public class RedisClientProvider {

    @Inject
    @Named("redis.database")
    private Integer database;
    @Inject
    @Named("redis.host")
    private String host;
    @Inject
    @Named("redis.port")
    private Integer port;
    @Inject
    @Named("redis.password")
    private String password;
    @Inject
    @Named("redis.pool.max.active")
    private Integer maxActive;
    @Inject
    @Named("redis.pool.max.idle")
    private Integer maxIdle;
    @Inject
    @Named("redis.pool.max.wait")
    private Integer maxWait;
    @Inject
    @Named("redis.pool.min.idle")
    private Integer minIdle;
    @Inject
    @Named("redis.timeout")
    private Integer timeout;

    private static ShardedJedisPool shardedPool;

    private ShardedJedisPool getJedisPool() {
        if (Objects.isNull(shardedPool)) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(this.maxActive);
            config.setMaxWaitMillis(this.maxWait);
            config.setMaxIdle(this.maxIdle);
            config.setMinIdle(this.minIdle);
            JedisShardInfo info = new JedisShardInfo(this.host, this.port.intValue(),
                    this.timeout.intValue());
            if (this.password != null && !this.password.isEmpty()) {
                info.setPassword(password);
            }
            shardedPool = new ShardedJedisPool(config, Arrays.asList(new JedisShardInfo[]{info}));
        } else {
            return shardedPool;
        }
        return shardedPool;
    }

    public ShardedJedis getResource(){
        ShardedJedis resource = this.getJedisPool().getResource();
        return resource;
    }


}
