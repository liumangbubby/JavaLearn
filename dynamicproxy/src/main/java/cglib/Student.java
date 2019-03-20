package cglib;

/**
 * @Author: wei.wang
 * @Description:
 * @Date 2018/9/18 13:19
 * @Modified
 */
public class Student {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }
}
