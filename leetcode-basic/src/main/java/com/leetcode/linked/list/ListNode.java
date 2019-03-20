package com.leetcode.linked.list;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

 @Override
 public String toString() {
  final StringBuilder sb = new StringBuilder("ListNode{");
  sb.append("val=").append(val);
  sb.append(", next=").append(next == null ? null : next.val);
  sb.append('}');
  return sb.toString();
 }
}