package com.lwj.service.impl;

import com.lwj.Annotation.AutoCache;
import com.lwj.service.ICacheService;
import org.springframework.stereotype.Service;

/**
 * @Auth: lwj
 * @Date: 2019/4/25 15:28
 */
@Service("cacheService")
public class CacheServiceImpl implements ICacheService {


    @Override
    @AutoCache
    public String shit() {
        System.out.println("shit~shit~shit");
        return "200";
    }
}
