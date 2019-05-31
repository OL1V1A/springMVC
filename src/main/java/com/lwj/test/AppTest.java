package com.lwj.test;

import com.lwj.service.ICacheService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auth: lwj
 * @Date: 2019/4/25 15:51
 */
public class AppTest {
    public static void main(String[] args) {
        BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext.xml");
        ICacheService cacheService = (ICacheService) bf.getBean("cacheService");
        for (int i=0;i<5;i++){
            String result = cacheService.shit();
            System.out.println("shit()方法执行结果是："+result);
            System.out.println("================================");
        }
        System.out.println("Apptest最终的cacheService="+cacheService.getClass().getName());
    }
}
