package com.leetcode;

public class ReverseIntNumber {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords(12345));
    }

    /**
     * 求余运算%,巧妙
     */
    public static Integer reverseLeftWords(Integer s) {
        int res = 0;
        while (s != 0) {
            res = 10 * res + s % 10;
            s = s / 10;
        }
        return res;
    }
}