package com.leetcode.array;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/27 9:56
 * @Modified
 */
public class Heap<T> {
    private Object[] arrays = new Object[16];
    private int length;

    public void add(T val) {
        int index = length + 1;
        arrays[index] = val;
        int i = index;
        Comparable key = (Comparable) val;
        while (i > 1 && key.compareTo(arrays[i / 2]) > 0) {
            Object temp = arrays[i];
            arrays[i] = arrays[i / 2];
            arrays[i / 2] = temp;
            i /= 2;
        }
        length++;
    }

    public void remove(int index) {
        Object temp = arrays[length];
        arrays[length] = arrays[index];
        arrays[index] = temp;
        arrays[length] = null;
        length--;
        int i = index;
        while (true) {
            Comparable key = (Comparable) arrays[i * 2];
            int swap =  key.compareTo(arrays[i * 2 + 1]) > 0 ? i * 2 : i * 2 + 1;
            key = (Comparable) arrays[swap];
            if(key.compareTo(arrays[i]) > 0) {
                Object t = arrays[swap];
                arrays[swap] = arrays[i];
                arrays[i] = t;
            } else {
                break;
            }
            i = swap;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        System.out.println(Arrays.toString(heap.heapify(new int[]{3,1,2,4,234,5,8,9,10,43}, 6)));
    }

    public int[] heapify(int[] target, int l) {
        // 先把target中所有数据后移一位
        for(int i = l - 1; i >= 0; i--) {
            target[i + 1] = target[i];
        }
        // 堆化
        for (int i = l; i >= 1; i--) {
            int t = i;
            while (true) {
                int tem = t;
                if(t * 2 <= l && target[t] < target[t * 2]) {
                    tem = t * 2;
                }
                if(t * 2 + 1 <= l && target[tem] < target[t * 2 + 1]) {
                    tem = t * 2 + 1;
                }
                if(tem == t) break;
                int temp = target[t];
                target[t] = target[tem];
                target[tem] = temp;
                t = tem;
            }
        }
        return target;
    }
}
