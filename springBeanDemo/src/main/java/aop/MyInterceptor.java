package aop;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        return false;
    }

    @Override
    public void after() {

    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("MyInterceptor around");
        Object o = invocation.proceed();
        return o;
    }

    @Override
    public void afterReturning() {

    }

    @Override
    public void afterThrowing() {

    }

    @Override
    public boolean useAround() {
        return true;
    }
}
