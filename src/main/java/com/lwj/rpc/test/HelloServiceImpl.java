package com.lwj.rpc.test;

/**
 * @Auth: lwj
 * @Date: 2019/6/25 10:17
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return " Hello " + name;
    }
}
