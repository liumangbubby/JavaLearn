package com.leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/25 16:11
 * @Modified
 */
public class FirstBinarySearch {
    private int badd = 0;

    public FirstBinarySearch(int badd) {
        this.badd = badd;
    }

    public int firstBadVersion(int n) {
        int p_begin = 1;
        int p_end = n;
        int p_mid = p_end;
        int ret = p_mid;
        while(p_begin <= p_end) {
            p_mid = p_begin + (p_end - p_begin) / 2;
            boolean b = isBadVersion(p_mid);
            if(b) {
                ret = p_mid;
                p_end = p_mid - 1;
            } else {
                p_begin = p_mid + 1;
            }
        }
        return ret;
    }

    private boolean isBadVersion(int end) {
        return end >= this.badd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int bad = Integer.parseInt(line);

            int ret = new FirstBinarySearch(bad).firstBadVersion(n);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}
