package cglib;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/5 19:53
 * @Modified
 */
public class CglibTest {
    public static void main(String[] args) {
        Student studentProxy = (Student) new CglibHoseeProxy().bind(new Student("ww"));
        studentProxy.giveMoney();
    }
}
