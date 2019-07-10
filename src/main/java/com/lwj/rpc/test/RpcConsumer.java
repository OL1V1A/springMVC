package com.lwj.rpc.test;

import com.lwj.rpc.RpcFramework;

import java.util.concurrent.TimeUnit;

/**
 * @Auth: lwj
 * @Date: 2019/6/25 10:18
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String hello = service.hello("World " + i);
            System.out.println(hello);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
