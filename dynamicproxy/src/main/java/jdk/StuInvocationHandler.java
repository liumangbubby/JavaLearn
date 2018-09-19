package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wei.wang
 * @Description:
 * @Date 2018/9/18 13:24
 * @Modified
 */
public class StuInvocationHandler<T> implements InvocationHandler {
    // 被代理对象
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println("代理执行" + method + "方法");
        MonitorUtil.start();
        Object ret = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return ret;
    }
}
