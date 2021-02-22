package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理只提供接口的代理，不支持类的代理。核心InvocationHandler接口和Proxy类，
 * InvocationHandler 通过invoke()方法反射来调用目标类中的代码，动态地将横切逻辑和业务编织在一 起;
 * 接着，Proxy利用 InvocationHandler动态创建一个符合某一接口的的实例, 生成目标类的代理对象。
 */
public class JdkProxy {

    public static void main(String[] args) {
        AddOrder p = getAddOrder();
        p.addOrder();
    }

    private static AddOrder getAddOrder() {
        AddOrder addOrder = new AddOrderImpl();
        return (AddOrder) Proxy.newProxyInstance(addOrder.getClass().getClassLoader(),
                addOrder.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("----");
                        Object o = method.invoke(addOrder, args);
                        System.out.println("----");
                        return o;
                    }
                });
    }


}
