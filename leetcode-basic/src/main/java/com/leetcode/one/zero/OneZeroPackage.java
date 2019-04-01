package com.leetcode.one.zero;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: wei.wang
 * @Description: 0-1 背包问题的回溯方法解决
 * @Date 2019/4/1 15:09
 * @Modified
 */
public class OneZeroPackage {
    /**
     * 存储背包中物品总重量的最大值
     */
    public int maxW = Integer.MIN_VALUE;

    /**
     * cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
     * w 背包重量；items 表示每个物品的重量；n 表示物品个数
     * 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
     * f(0, 0, a, 10, 100)
     * @param i
     * @param cw
     * @param items
     * @param n
     * @param w
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i + 1, cw, items, n, w);
        // 已经超过可以背包承受的重量的时候，就不要再装了
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {
        OneZeroPackage oneZeroPackage = new OneZeroPackage();
        int[] a = new int[]{34, 65, 23, 12, 46, 42, 23, 45, 35, 63, 93, 131, 102, 31};
        a = IntStream.iterate(1, i -> i + 1).limit(10).toArray();
        oneZeroPackage.f(0, 0, a, 3, 100);
        System.out.println(oneZeroPackage.maxW);
    }
}
