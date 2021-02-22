package aop;

import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器
 */
public interface Interceptor {
    /**
     * 事前方法
     *
     * @return
     */
    public boolean before();

    /**
     * 事后方法
     */
    public void after();

    /**
     * 取代原有事件方法
     * @invocation 回调参数 通过他的proceed方法，回调原有事件
     *
     * @return 返回原有事件
     */
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    public void afterReturning();

    public void afterThrowing();

    /**
     * 是否使用around方法取代原有方法
     */
    boolean useAround();
}
