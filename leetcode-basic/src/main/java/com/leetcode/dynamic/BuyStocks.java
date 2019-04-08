package com.leetcode.dynamic;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/3 17:36
 * @Modified
 */
public class BuyStocks {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++) {
                max = Integer.max(max, prices[j] - prices[i]);
            }
        }
        return max > 0 ? max : 0;
    }

    public static void main(String[] args) {
        System.out.println(0 ^ 1);
    }
}
