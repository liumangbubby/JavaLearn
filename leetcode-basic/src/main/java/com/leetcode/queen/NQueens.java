package com.leetcode.queen;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/1 11:17
 * @Modified
 */
public class NQueens {
    int n;
    /**
     * 下标表示行，值表示 queen 存储在哪一行
     */
    int[] result;

    public NQueens(int n) {
        this.n = n;
        this.result = new int[n];
    }

    protected int count;

    /**
     * 检查 row 行
     * @param row 行数从0开始
     */
    public int cal8queens(int row) {
        // 8 个棋子都放置好了，打印结果
        if (row == n) {
            printQueens(result);
            return ++count;
        }
        // 每一行都有 8 种放法
        for (int column = 0; column < n; ++column) {
            // 有些放法不满足要求
            if (isOk(row, column)) {
                // 第 row 行的棋子放到了 column 列
                result[row] = column;
                // 考察下一行
                cal8queens(row+1);
            }
        }
        return count;
    }

    /**
     * 判断 row 行 column 列放置是否合适
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        // 逐行往上考察每一行，因为放 queen 是从上往下放的因此只用向上考察
        for (int i = row-1; i >= 0; --i) {
            // 第 i 行的 column 列有棋子吗？
            if (result[i] == column) return false;
            // 考察左上对角线：第 i 行 leftup 列有棋子吗？
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }
            // 考察右上对角线：第 i 行 rightup 列有棋子吗？
            if (rightup < n) {
                if (result[i] == rightup) return false;
            }
            --leftup; ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < n; ++row) {
            for (int column = 0; column < n; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(4);
        System.out.println(nQueens.cal8queens(0));
    }
}
