package com.colleations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/8 15:37
 * @Modified
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        list.add(random.nextInt());
        list.add(random.nextInt());
        list.add(random.nextInt());
        list.add(random.nextInt());
        list.add(random.nextInt());
        list.add(random.nextInt());
        list.add(random.nextInt());

        System.out.println(list);
        List<Integer> subList = list.subList(1, 4);
        subList.set(0, 0);
        subList.set(1, 0);
        System.out.println(list);

    }
}
