package com.leetcode.sort;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/15 9:01
 * @Modified
 */
public class Quicksort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(new Quicksort().sort(array)));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int b, int e) {
        // 结束条件
        if(b >= e) return;
        int pivotIndex = partition(array, b, e);
        quickSort(array, b, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, e);
    }

    private int partition(int[] array, int b, int e) {
        int pivot = array[e];
        int head = b;
        for (int i = b; i < e; i++) {
            if(array[i] < pivot) {
                int temp = array[head];
                array[head] = array[i];
                array[i] = temp;
                head++;
            }
        }
        int temp = array[e];
        array[e] = array[head];
        array[head] = temp;
        return head;
    }
}
