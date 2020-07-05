package com.desing;

/**
 * 保证一个类只有一个示例，并且提供一个可以全局访问的入口。
 * 节省内存 节省计算
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("singleton init ");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
