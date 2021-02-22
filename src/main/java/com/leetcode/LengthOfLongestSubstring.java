package com.leetcode;

/**
 * 思路 "abcac"
 * a与b比较
 * a b 与c比较
 * a b c 与a比较
 * b与
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcac"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {

        }
        int start = 0;
        int maxLenth = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = start; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    start = j + 1;
                    break;
                }
            }
            maxLenth = Math.max(maxLenth, i - start + 1);
        }
        return maxLenth;
    }
}
