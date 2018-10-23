package cn.no7player.config;

import redis.clients.jedis.*;

/** redis 加载缓存
 *  Created by lijm on 2018-04-03.
 */
public class RedisConfig{

    private Jedis jedis;
    private JedisPool jedisPool;
    private ShardedJedis shardedJedis;
    private ShardedJedisPool shardedJedisPool;

}
