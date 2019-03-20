package com.xpand.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2018/10/18 15:00
 * @Modified
 */
public class SpringBootstrap {
    public static void main(String[] args) {
        System.out.println(testFinally());
        return;
    }

    private static int testFinally() {
        int i = 0;
        try{
            i += 10;
            // i = 10 / 0;
            return i += 5;
        } finally {
            i++;
            System.out.println("finally "  + i);
        }
    }
}
