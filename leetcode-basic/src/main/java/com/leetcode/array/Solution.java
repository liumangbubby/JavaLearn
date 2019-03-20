package com.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/11 9:59
 * @Modified
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Character, List<Point>> map = new HashMap<>(9);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                char key = board[y][x];
                if (key >= 49 && key <= 57) {
                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(new Point(x, y));
                }
            }
        }
        for (Map.Entry<Character, List<Point>> entry : map.entrySet()) {
            List<Point> list = entry.getValue();
            if (list.size() > 1) {
                for (int i = 0; i < list.size(); i++) {
                    for (int h = i + 1; h < list.size(); h++) {
                        Point p1 = list.get(i);
                        Point p2 = list.get(h);
                        boolean inline = p1.x == p2.x || p1.y == p2.y;
                        boolean inArea = p1.x / 3 == p2.x / 3 && p1.y / 3 == p2.y / 3;
                        if (inline || inArea) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }

    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        int r = 0;
        for (int t = x; t != 0; t /= 10) {
            if (Integer.MAX_VALUE / 10 < r || Integer.MIN_VALUE / 10 > r) {
                return 0;
            }
            r = r * 10 + (t % 10);
        }
        return r;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> chars = new HashMap<>(s.length());
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            chars.putIfAbsent(charArray[i], 0);
            chars.put(charArray[i], chars.get(charArray[i]) + 1);
        }
        int idx = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                idx = Math.min(s.indexOf(entry.getKey()), idx);
            }
        }
        return idx == Integer.MAX_VALUE ? -1 : idx;
    }

    public boolean isAnagram(String s, String t) {
        if ("".equals(s) && "".equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (char c : chars) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        char[] temp = new char[s.length()];
        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                temp[i++] = c;
            }
        }
        for (int f = 0; f < Math.ceil(i / 2); f++) {
            char c = temp[f];
            char c1 = temp[i - f - 1];
            if (c >= '0' && c <= '9' && ((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z'))) {
                return false;
            }
            if (c1 >= '0' && c1 <= '9' && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                return false;
            }
            if (c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9') {
                if (c - c1 != 0) {
                    return false;
                }
            }
            if (((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) && ((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z'))) {
                if (c - c1 != 0 && Math.abs(c - c1) != ('a' - 'A')) {
                    return false;
                }
            }
        }
        return true;
    }

    public int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        long ret = 0;
        for (int i = chars.length - 1, h = 0; i >= 0; i--) {
            if (i == 0) {
                if (chars[i] == '-') {
                    ret = -ret;
                    if (ret < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    } else {
                        return (int) ret;
                    }
                }
                if (chars[i] == '+') {
                    if (ret > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    return (int) ret;
                }
            }
            if (isNumberChar(chars[i])) {
                long add = (long) ((chars[i] - '0') * Math.pow(10, h++));
                ret += add;
            } else {
                ret = 0;
                h = 0;
            }
        }
        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ret;
    }

    private boolean isNumberChar(char c) {
        return c >= '0' && c <= '9';
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("11");
        char[] cn = sb.toString().toCharArray();
        for (int t = 1; t < n - 1; t++) {
            sb = new StringBuilder();
            int rep = 0;
            char lastChar = cn[0];
            for (int i = 0; i < cn.length; i++) {
                if (cn[i] == lastChar) {
                    rep++;
                } else {
                    sb.append(rep).append(lastChar);
                    rep = 1;
                    lastChar = cn[i];
                }
            }
            sb.append(rep).append(lastChar);
            cn = sb.toString().toCharArray();
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for(int f = 0; f < Integer.MAX_VALUE; f++) {
            for (int i = 0; i < strs.length; i++) {
                if(f >= strs[i].length()) {
                    sb.setLength(strs[i].length());
                    return sb.toString();
                }
                if(sb.length() <= f) {
                    sb.append(strs[i].charAt(f));
                } else {
                    if(sb.charAt(f) != strs[i].charAt(f)) {
                        sb.deleteCharAt(f);
                        return sb.toString();
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("前缀：" + s.longestCommonPrefix(new String[]{"aa","a"}));
    }
}
