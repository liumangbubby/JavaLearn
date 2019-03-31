package com.leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0)
            return tasks.length;
        int count = 0;
        SortedMap<Character, Integer> cast = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            cast.putIfAbsent(c, 0);
            map.putIfAbsent(c, new LinkedList<>());
            map.get(c).add(i);
        }
        for (int length = tasks.length; length > 0; length--) {
            char c = 0;
            int min = Integer.MAX_VALUE;
            // 找到代价最小的任务
            for (Map.Entry<Character, Integer> entry : cast.entrySet()) {
                if (entry.getValue() == 0) {
                    c = entry.getKey();
                    break;
                } else {
                    if (entry.getValue() < min) {
                        c = entry.getKey();
                        min = entry.getValue();
                    }
                }
            }
            // 需要等待
            Integer waitTime = cast.get(c);
            if (waitTime > 0) {
                count += waitTime;
                chargeCast(cast, waitTime);
                System.out.printf("wait %d   ", waitTime);
            }
            count++;
            cast.put(c, n + 1);
            chargeCast(cast, 1);
            System.out.print(tasks[map.get(c).poll()] + "   ");
            if(map.get(c).size() == 0)
                cast.remove(c);
        }
        return count;
    }

    private void chargeCast(Map<Character, Integer> cast, Integer waitTime) {
        for (Map.Entry<Character, Integer> entry : cast.entrySet()) {
            entry.setValue(entry.getValue() - waitTime);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }
}