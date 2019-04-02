package com.leetcode.one.zero;

import java.util.Arrays;

/**
 * @author: wei.wang
 * @Description: 0-1 背包问题动态规划解决
 * @Date 2019/4/2 13:21
 * @Modified
 */
public class OneZeroPackage2 {
    /**
     * 背包最大重量
     */
    private int maxWeight;

    /**
     * 记录背包重量分配的可能性
     */
    private int[] weightDistribution;

    public OneZeroPackage2(int maxWeight) {
        this.maxWeight = maxWeight;
        this.weightDistribution = new int[maxWeight + 1];
    }

    /**
     * 分配不超过背包最大重量的最有效货物选择方案
     * @param goodsWeight 每个货物重量列表
     * @return 最佳货物选择方案的总重量
     */
    public int optimalAllocation(int[] goodsWeight) {
        int weight = 0;
        int goodsNum = goodsWeight.length;
        // 货物分配可能重量的尾有效位标记
        int last = 0;
        for (int i = 0; i < goodsNum; i++) {
            int goodWeight = goodsWeight[i];
            int[] temp = Arrays.copyOf(weightDistribution, weightDistribution.length);
            // 从尾部往前遍历记录选择这个货物的影响
            for (int j = temp.length - 1; j >= 0; j--) {
                if(temp[j] == 1 && j + goodWeight <= maxWeight)
                    temp[j + goodWeight] = 1;
            }
            // 选择货物
            temp[goodWeight] = 1;
            weightDistribution = temp;
        }
        // 选择最大的货物分配重量
        for (int i = weightDistribution.length - 1; i >= 0; i--) {
            if(weightDistribution[i] == 1){
                weight = i;
                break;
            }
        }
        return weight;
    }

    public static void main(String[] args) {
        OneZeroPackage2 package2 = new OneZeroPackage2(9);
        System.out.println(package2.optimalAllocation(new int[]{2, 2, 4, 6, 3}));
    }
}
