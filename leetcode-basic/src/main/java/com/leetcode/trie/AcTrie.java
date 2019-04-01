package com.leetcode.trie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/1 10:35
 * @Modified
 */
public class AcTrie {
    private AcNode root = new AcNode('/');
    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null) continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    public void match(char[] text) { // text 是主串
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; ++i) {
            int idx = text[i] - 'a';
            // 失败指针发挥作用的地方，这个地方为啥要用失败指针？
            // p.children[idx] == null 表明当前模式串匹配失败，那么切换到一个和当前模式串有相同后缀的另一个模式串再尝试匹配
            // p == root 表明所有模式串都匹配失败
            while (p.children[idx] == null && p != root) {
                p = p.fail;
            }
            // 主串当前字符出现在模式串中，继续往下个字符搜索
            p = p.children[idx];
            // 如果没有匹配的，从 root 开始重新匹配
            if (p == null) p = root;
            AcNode tmp = p;
            // 打印出可以匹配的模式串
            while (tmp != root) {
                if (tmp.isEndingChar == true) {
                    int pos = i-tmp.length+1;
                    System.out.println(" 匹配起始下标 " + pos + "; 长度 " + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }

}
