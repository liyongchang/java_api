package com.desing.singleton;

/**
 * 保证一个类只有一个示例，并且提供一个可以全局访问的入口。
 * 节省内存 节省计算
 * double check lock
 */
public class Singleton1 {
    //volatile 非原子 禁止指令充排序
    // 1.给 Singleton1 分配内存空间
    // 2.调用Singleton1构造函数初始化singleton
    // 3.将Singleton1对象指向分配的内存空间
    // 2 3 不存在数据依赖关系存在重排优化
    // 123 132顺序
    private volatile static Singleton1 singleton;

    private Singleton1() {
        System.out.println("singleton1 init ");
    }

    public static Singleton1 getInstance() {
        //第一层判断 线程串行执行  提高销量不必竞争锁
        if (singleton == null) {
            synchronized (Singleton1.class) {
                //第二层判断 第一个执行完new Singleton1后退出保护区域，第二个也会创建示例。
                if (singleton == null) {
                    singleton = new Singleton1();//new 完之后释放锁
                }
            }
        }
        return singleton;
    }
}
