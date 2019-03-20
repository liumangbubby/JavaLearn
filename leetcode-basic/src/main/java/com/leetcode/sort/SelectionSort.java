package com.leetcode.sort;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wei.wang
 * @Description: 选择排序
 * @Date 2019/3/14 10:30
 * @Modified
 */
public class SelectionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(new SelectionSort().sort(array)));
    }

    private int[] sort(int[] array) {
        for (int sorted = 0; sorted < array.length; sorted++) {
            int minIndex = sorted;
            for (int i = sorted; i < array.length; i++) {
                if(array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[sorted];
            array[sorted] = temp;
        }
        return array;
    }
}
