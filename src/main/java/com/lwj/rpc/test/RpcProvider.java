package com.lwj.rpc.test;

import com.lwj.rpc.RpcFramework;

/**
 * @Auth: lwj
 * @Date: 2019/6/25 10:16
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }

}
