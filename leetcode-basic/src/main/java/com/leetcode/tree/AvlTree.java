package com.leetcode.tree;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/20 13:28
 * @Modified
 */
public class AvlTree<T> {
    private static final String FORMAT = "|%4s %1s|  ";
    private Node<T> root = new Node<>(0);
    class Node<T> {
        T data;
        int deep;
        Node<T> left;
        Node<T> right;

        public Node(int deep) {
            this.deep = deep;
        }
    }

    public static void main(String[] args) {
        MyTreeMap<Integer, Object> rbTree = new MyTreeMap<>();
        rbTree.put(3, "");
        rbTree.put(4, "");
        rbTree.put(6, "");
        rbTree.put(8, "");
        rbTree.put(11, "");
        rbTree.put(13, "");
        rbTree.put(17, "");
        rbTree.put(15, "");
        rbTree.put(25, "");
        rbTree.put(22, "");
        rbTree.put(27, "");
        System.out.println(rbTree);
        rbTree.put(21, "");
        System.out.println(rbTree);
    }

    public static String printTreeMap(TreeMap map) {
        try {
            StringBuilder sb = new StringBuilder();
            int leftDeep = 0;
            // 查找最左子节点深度
            Field root = map.getClass().getDeclaredField("root");
            root.setAccessible(true);
            Map.Entry entry = (Map.Entry) root.get(map);
            while(entry != null) {
                leftDeep++;
                Field left = entry.getClass().getDeclaredField("left");
                left.setAccessible(true);
                entry = (Map.Entry) left.get(entry);
            }
            System.out.println(leftDeep);
            // 查找最右节点深度
            int rightDeep = 0;
            entry = (Map.Entry) root.get(map);
            while(entry != null) {
                rightDeep++;
                Field right = entry.getClass().getDeclaredField("right");
                right.setAccessible(true);
                entry = (Map.Entry) right.get(entry);
            }
            System.out.println(rightDeep);
            // 输出格式
            int maxDeep = Integer.max(leftDeep, rightDeep);
            int maxSlot = (int) (Math.pow(2, maxDeep)) - 1;
            int point = (int) Math.floor(maxSlot / 2);
            for (int i = 1; i <= maxDeep; i++) {
                int nodeNum = (int) (Math.pow(2, i - 1));
                for (int f = 1; f <= maxSlot; f++) {
                    if(f == point) {
                        System.out.printf(FORMAT, "1", "B");
                    } else {
                        System.out.printf("%10s", "");
                    }
                }
                System.out.println();
                point = point >> 1;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

}
