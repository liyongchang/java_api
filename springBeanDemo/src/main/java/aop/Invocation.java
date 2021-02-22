package aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
    private Object[] params;
    private Method method;
    private Object object;

    public Invocation(Object[] params, Method method, Object object) {
        this.params = params;
        this.method = method;
        this.object = object;
    }

    /**
     * 以反射的形式去调用原有的方法。
     */
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(object, params);
    }
}
