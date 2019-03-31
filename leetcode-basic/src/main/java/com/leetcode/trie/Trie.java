package com.leetcode.trie;

import java.util.stream.Stream;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/30 14:13
 * @Modified
 */
public class Trie {
    private TrieNode head = new TrieNode('/');

    public void insert(char[] word) {
        TrieNode temp = head;
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            int index = c - 'a';
            if(temp.next[index] == null) {
                temp.next[index] = new TrieNode(c);
                if(i == word.length - 1) {
                    temp.next[index].endFlag = true;
                }
            }
            temp = temp.next[index];
        }
    }

    public boolean find(String str) {
        TrieNode temp = head;
        for(char c : str.toCharArray()) {
            int index = c - 'a';
            if(temp.next[index] == null) {
                return false;
            }
            temp = temp.next[index];
        }
        return temp.endFlag;
    }

    public void printFromat() {
        deepSearch(head, new StringBuilder(), 0);
    }

    private void deepSearch(TrieNode head, StringBuilder sb, int i) {
        if(head == null) {
            return;
        }
        if(sb.length() <= i) {
            sb.append(head.data);
        } else {
            sb.setCharAt(i, head.data);
        }
        if(head.endFlag) {
            System.out.println(sb.toString());
            sb.setLength(1);
            return;
        }
        for(TrieNode c : head.next) {
            deepSearch(c, sb, i + 1);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Stream.of("help", "sdfe", "hwer", "dfwdrqsadwe").forEach(w -> trie.insert(w.toCharArray()));
        trie.printFromat();
        System.out.println(trie.find("hel"));
        System.out.println(trie.find("help"));
    }
}
