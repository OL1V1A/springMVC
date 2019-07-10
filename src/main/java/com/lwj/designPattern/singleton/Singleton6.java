package com.lwj.designPattern.singleton;

/**
 * 枚举（最佳选择）
 * 它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化
 * @Auth: lwj
 * @Date: 2019/7/3 11:34
 */
public enum  Singleton6 {


    INSTANCE;

    public void print(){
        System.out.println("Enum Singleton");
    }

}
