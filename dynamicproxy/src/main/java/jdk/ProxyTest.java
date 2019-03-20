package jdk;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: wei.wang
 * @Description:
 * @Date 2018/9/18 13:30
 * @Modified
 */
public class ProxyTest {
    public static void main(String[] args) throws IOException {
        Person zhangsan = new Student("张三");
        InvocationHandler stuHandler = new StuInvocationHandler(zhangsan);
        Person stuProxy = (Person) Proxy.newProxyInstance(stuHandler.getClass().getClassLoader(), new Class[]{Person.class}, stuHandler);
        stuProxy.giveMoney();
    }
}
