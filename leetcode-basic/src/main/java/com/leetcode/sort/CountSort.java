package com.leetcode.sort;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/15 18:51
 * @Modified
 */
public class CountSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(new CountSort().sort(array)));
    }

    private int[] sort(int[] array) {
        // 遍历 array 找出最大值和最小值
        int min = Integer.MAX_VALUE, max = 0;
        for (int i: array) {
            if(i < min)
                min = i;
            if(i > max)
                max = i;
        }
        // 构造 min 到 max 的数组
        int[] bitmap = new int[max - min + 1];
        // 统计各个数出现的次数
        for (int i : array) {
            bitmap[i - min]++;
        }
        // 修改 bitmap 中的值为当前index（包含）之前值的和
        int count = 0;
        for (int i = 0; i < bitmap.length; i++) {
            count += bitmap[i];
            bitmap[i] = count;
        }
        // 排序实现：倒序遍历 array 中的元素，到 bitmap 中找到当前位置并把 bitmap 值减一
        int ret[] = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int index = bitmap[array[i] - min] - 1;
            ret[index] = array[i];
            bitmap[array[i] - min]--;
        }
        return ret;
    }


}
