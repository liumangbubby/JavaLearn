package com.leetcode.one.zero;

import java.util.Arrays;

/**
 * @author: wei.wang
 * @Description: 0-1 背包问题动态规划解决
 * @Date 2019/4/2 13:21
 * @Modified
 */
public class OneZeroPackage3 {
    /**
     * 背包最大重量
     */
    private int maxWeight;

    /**
     * 记录背包重量分配的可能性
     */
    private int[][] weightDistribution;

    public OneZeroPackage3(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * 在满足货物未超过背包容量的情况下选择最大货物价值
     * @param goodsWeight 每个货物重量列表
     * @param goodsValue 每个货物价值列表
     * @return 货物的最大值
     */
    public int optimalAllocation(int[] goodsWeight, int[] goodsValue) {
        int goodsNum = goodsWeight.length;
        this.weightDistribution = new int[goodsNum][maxWeight + 1];
        int value = 0;
        for (int i = 0; i < goodsNum; i++) {
            // 当前货物价值
            int goodValue = goodsValue[i];
            int goodWeight = goodsWeight[i];
            for (int j = weightDistribution[i].length - 1; i > 0 && j >= 0; j--) {
                if(weightDistribution[i - 1][j] > 0) {
                    if(j + goodWeight <= maxWeight) {
                        int maxValue = Integer.max(weightDistribution[i][j + goodWeight], weightDistribution[i - 1][j] + goodValue);
                        weightDistribution[i][j + goodWeight] = maxValue;
                    }
                    weightDistribution[i][j] = weightDistribution[i - 1][j];
                }
            }
            // 选择货物
            weightDistribution[i][goodWeight] = Integer.max(goodValue, weightDistribution[i][goodWeight]);
        }
        // 选择最大的货物分配重量
        for (int i = weightDistribution[goodsNum - 1].length - 1; i >= 0; i--) {
            if(weightDistribution[goodsNum - 1][i] > 0){
                value = Integer.max(weightDistribution[goodsNum - 1][i], value);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        OneZeroPackage3 package2 = new OneZeroPackage3(9);
        System.out.println(package2.optimalAllocation(new int[]{2, 2, 4, 6, 3}, new int[]{1, 4, 3, 4, 5}));
    }
}
