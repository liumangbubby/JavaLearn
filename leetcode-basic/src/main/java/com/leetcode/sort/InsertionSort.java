package com.leetcode.sort;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wei.wang
 * @Description: 插入排序
 * @Date 2019/3/14 9:52
 * @Modified
 */
public class InsertionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(new InsertionSort().sort(array)));
    }

    private int[] sort(int[] array) {
        for (int sorted = 1; sorted < array.length; sorted++) {
            // 查找出入index
            int index = -1;
            if(array[sorted - 1] <= array[sorted]) {
                continue;
            } else if(array[0] > array[sorted]) {
                index = 0;
            } else {
                for (int i = 0; i < sorted; i++) {
                    if (array[i] > array[sorted]) {
                        index = i;
                    }
                }
            }
            int temp = array[sorted];
            // 从 (index, sorted] 直接的元素全部后移一位
            for (int i = sorted; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = temp;
        }
        return array;
    }
}
