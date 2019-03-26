package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int deep = 1;
        if(root.left == null && root.right == null){
            return deep;
        }
        if(root.left != null || root.right != null) {
            int left = 0, right = 0;
            if(root.left != null) {
                left = maxDepth(root.left);
            }
            if(root.right != null) {
                right = maxDepth(root.right);
            }
            deep += Integer.max(left, right);
        }
        return deep;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] nums, int b, int e) {
        if(b > e)
            return null;
        int mid = b + (e - b) / 2;
        //if(root == null)
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, b, mid - 1);
        root.right = buildTree(nums, mid + 1, e);
        return root;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        System.out.println(treeNodeToString(solution.sortedArrayToBST(stringToIntegerArray(in.nextLine()))));
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
}