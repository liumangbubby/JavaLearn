package com.leetcode.dynamic;

/**
 *
 */
class ClimbTheStairs {
    int[][] tables;
    public int climbStairs(int n) {
        if(n <= 1) return n;
        tables = new int[n][n];
        int type = 0;
        // 第一次上楼梯初始化
        tables[0][0] = 1;
        tables[0][1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if(j == n - 1)
                    tables[i][j] += tables[i - 1][j];
                if(tables[i - 1][j] > 0 && j + 1 < n) {
                    tables[i][j + 1] += tables[i - 1][j];
                }
                if(tables[i - 1][j] > 0 && j + 2 < n) {
                    tables[i][j + 2] += tables[i - 1][j];
                }
            }
        }
        return tables[n - 1][n - 1];
    }

    public static void main(String[] args) {
        ClimbTheStairs climbTheStairs = new ClimbTheStairs();
        System.out.println(climbTheStairs.climbStairs(4));
    }
}