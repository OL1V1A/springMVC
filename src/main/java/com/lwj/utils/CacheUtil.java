package com.lwj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auth: lwj
 * @Date: 2019/4/25 15:31
 */
@Component
public class CacheUtil {

    private static Logger log = LoggerFactory.getLogger(CacheUtil.class);

    private Map<String,Object> cache;
    public CacheUtil(){
        cache = new ConcurrentHashMap<>();
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object getCache(String key){
        if (isCached(key)){
            Object bean = cache.get(key);
            log.info("读取缓存成功 key="+key+" \t value="+bean );
            return bean;
        }else{
            System.out.println("key不存在");
            return null;
        }
    }

    /**
     * 写入缓存
     * @param key
     * @param bean
     * @return
     */
    public boolean writeCache(String key, Object bean){
        if (!isCached(key)){
            cache.put(key,bean);
            log.info("写入缓存成功：key="+key+"\t value="+bean);
            return true;
        }else{
            log.info("key已存在");
            return false;
        }
    }

    /**
     * 判断是否存在缓存
     * @param key
     * @return
     */
    public boolean isCached(String key){
        return cache.containsKey(key);

    }

    /**
     * 修改缓存
     * @param key
     * @param bean
     * @return
     */
    public boolean setCache(String key,Object bean){
        if(isCached(key)){

            cache.put(key,bean);
            return true;
        }else{
            log.info("key 不存在");
            return false;
        }
    }
}
