package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import jdk.MonitorUtil;

/**
 * @author wei.wang
 */
public class CglibHoseeProxy {
    Object obj;

    public Object bind(final Object target) {
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args,
                                    MethodProxy proxy) throws Throwable {
                System.out.println("代理执行" + method + "方法");
                MonitorUtil.start();
                Object res = method.invoke(target, args);
                MonitorUtil.finish(method.getName());
                return res;
            }
        });
        return enhancer.create();
    }
}