package com.leetcode.trie;

public class AcNode {
    public char data;
    // 字符集只包含 a~z 这 26 个字符
    public AcNode[] children = new AcNode[26];
    // 结尾字符为 true
    public boolean isEndingChar = false;
    // 当 isEndingChar=true 时，记录模式串长度
    public int length = -1;
    // 失败指针
    public AcNode fail;

    public AcNode(char data) {
        this.data = data;
    }
}
