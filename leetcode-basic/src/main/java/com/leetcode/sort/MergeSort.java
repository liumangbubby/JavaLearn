package com.leetcode.sort;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wei.wang
 * @Description: 归并排序
 * @Date 2019/3/14 11:19
 * @Modified
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(new MergeSort().sort(array)));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] array) {
        int[] ret = new int[array.length];
        if(ret.length <= 2) {
            if(ret.length == 1) {
                ret[0] = array[0];
            } else {
                ret[0] = Math.min(array[0], array[1]);
                ret[1] = Math.max(array[0], array[1]);
            }
            return ret;
        } else {
            int mid = ret.length / 2;
            int[] part1 = sort(Arrays.copyOfRange(array, 0, mid));
            int[] part2 = sort(Arrays.copyOfRange(array, mid, array.length));
            // 合并
            for (int i = 0, p1 = 0, p2 = 0; i < ret.length; i++) {
                if(p1 < part1.length && p2 < part2.length) {
                    if (part1[p1] < part2[p2]) {
                        ret[i] = part1[p1++];
                    } else {
                        ret[i] = part2[p2++];
                    }
                } else {
                    if(p1 >= part1.length) {
                        ret[i] = part2[p2++];continue;
                    }
                    if(p2 >= part2.length) {
                        ret[i] = part1[p1++];continue;
                    }
                }
            }
            return ret;
        }
    }
}
