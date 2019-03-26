package com.leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/25 10:08
 * @Modified
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point1 = m - 1;
        int point2 = n - 1;
        int point = m + n - 1;
        while (point1 >= 0 && point2 >= 0) {
            if(nums1[point1] > nums2[point2]) {
                nums1[point--] = nums1[point1];
                point1--;
            } else {
                nums1[point--] = nums2[point2];
                point2--;
            }
        }
        while(point1 >= 0) {
            nums1[point--] = nums1[point1--];
        }
        while(point2 >= 0) {
            nums1[point--] = nums2[point2--];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            new MergeArray().merge(nums1, m, nums2, n);
            String out = integerArrayToString(nums1);

            System.out.print(out);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
}
