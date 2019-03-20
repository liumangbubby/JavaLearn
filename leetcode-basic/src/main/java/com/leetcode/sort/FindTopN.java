package com.leetcode.sort;


import java.util.Scanner;

/**
 * @author: wei.wang
 * @Description: 在 O(n) 时间复杂度内找出数组中第K大的元素
 * @Date 2019/3/15 14:14
 * @Modified
 */
public class FindTopN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(new FindTopN().find(array, 3));
    }

    private int find(int[] array, int topN) {
        int e = array.length - 1;
        int b = 0;
        int pivotIndex = -1;
        while((pivotIndex = partition(array, b, e)) != topN) {
            if(pivotIndex < topN) {
                b = pivotIndex + 1;
            } else {
                e = pivotIndex - 1;
            }
        }
        return array[pivotIndex];
    }

    private int partition(int[] array, int b, int e) {
        int pivotIndex = e - 1;
        int head = b;
        for (int i = b; i <= e; i++) {
            if(array[i] > array[pivotIndex]){
                int temp = array[i];
                array[i] = array[head];
                array[head] = temp;
                head++;
            }
        }
        int temp = array[head];
        array[head] = array[pivotIndex];
        array[pivotIndex] = temp;
        return head;
    }
}
