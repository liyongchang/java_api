package com.leetcode;

public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("iloveyou", 2));
    }

    /**
     * 求余运算%,巧妙
     */
    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            System.out.println("i=" + i);
            System.out.println("s.length()=" + s.length());
            System.out.println(i % s.length());
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}