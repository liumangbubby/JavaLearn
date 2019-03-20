package com.leetcode.linked.list;

import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public void deleteNode(ListNode node) {
        ListNode point = node;
        while(point != null) {
            ListNode temp = point.next;
            if(temp.val == 5) {
                point.next = temp.next;
                temp.next = null;
            }
            System.out.println(point.val);
            point = point.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode ret = null;
        while(second != null) {
            ListNode tmpFirst = first;
            ListNode tmpSecond = second;
            first = second;
            second = second.next;
            if(tmpFirst == head) {
                tmpFirst.next = null;
            }
            tmpSecond.next = tmpFirst;
            ret = tmpSecond;
        }
        return ret;
    }

    /**
     * 反转链表递归法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        } else {
            ListNode l = reverseList1(head.next);
            ListNode t = l;
            while(t.next != null) {
                t = t.next;
            }
            head.next = null;
            t.next = head;
            return l;
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
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = null;
        if(l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            ListNode head2 = stringToListNode(in.readLine());

            ListNode ret = new Solution().mergeTwoLists(head, head2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}