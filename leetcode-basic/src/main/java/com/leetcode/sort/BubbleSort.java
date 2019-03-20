package com.leetcode.sort;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wei.wang
 * @Description: 冒泡排序
 * @Date 2019/3/14 9:34
 * @Modified
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] array = new int[split.length];
        for(int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int[] array) {
        for (int tail = array.length; tail > 0; tail--) {
            boolean change = false;
            for (int i = 1; i < tail; i++) {
                if(array[i - 1] > array[i]){
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    change = true;
                }
            }
            if(!change) {
                break;
            }
        }
        return array;
    }
}
