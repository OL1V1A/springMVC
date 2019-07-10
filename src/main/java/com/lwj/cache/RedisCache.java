package com.lwj.cache;

import com.lwj.utils.StringUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auth: lwj
 * @Date: 2019/1/17 14:07
 */
public class RedisCache {

    public static void main(String[] args) {
        RedisCache.initJedisPool("47.98.117.161", 6379, null, 2000);
        //RedisCache.setNx("redisdemo3","hahha");
//        delCache("testUser");
        String s = getCache("k2");
        System.out.println(s);
    }

    public static JedisPool jedisPool;

    public static synchronized void initJedisPool(JedisPool inJedisPool) {
        jedisPool = inJedisPool;
    }

    public static synchronized void initJedisPool(String host, Integer port, String secretKey, Integer timeout) {
        initJedisPool(host, port, secretKey, timeout, new JedisPoolConfig());
    }

    public static synchronized void initJedisPool(String host, Integer port, String secretKey, Integer timeout,
                                                  JedisPoolConfig jedisPoolConfig) {
        if (StringUtil.isNullOrEmpty(secretKey)) {
            secretKey = null;
        }
        JedisPool inJedisPool = new JedisPool(new JedisPoolConfig(), host, port, 10000, secretKey);
        initJedisPool(inJedisPool);
    }

    public static Integer setNx(String key, String value) {
        return setNx(key, value, null);
    }

    public static Integer setNx(String key, String value, Integer expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            Long result = jedis.setnx(key, value);
            if (expire != null) {
                jedis.expire(key, expire);
            }
            return result.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public static void delCache(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static String getCache(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
