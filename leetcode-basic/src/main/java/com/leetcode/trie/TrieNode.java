package com.leetcode.trie;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/30 10:14
 * @Modified
 */
public class TrieNode {
    protected char data;
    protected TrieNode[] next = new TrieNode[26];
    protected boolean endFlag;

    public TrieNode(char data) {
        this.data = data;
    }
}
