package jdk;

/**
 * @Author: wei.wang
 * @Description:
 * @Date 2018/9/18 13:21
 * @Modified
 */
public class MonitorUtil {
    private static ThreadLocal<Long> t1 = new ThreadLocal<>();

    public static void start() {
        t1.set(System.currentTimeMillis());
    }

    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - t1.get()) + "ms");
    }
}
