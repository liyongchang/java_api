package com.leetcode.reverse;

public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("iloveyou", 2));

        System.out.println(reverseTestSeven("iloveyou"));
    }

    public static String reverseTestSeven(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverseTestSeven(right) + reverseTestSeven(left);
    }
    /**
     * 求余运算%,巧妙
     */
    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}