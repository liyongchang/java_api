package com.leetcode.reverse;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] strArr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i > 0; i--) {
            sb.append(strArr[i]);
            if (!strArr[i].equals("")) {
                sb.append(" ");

            }
        }
        sb.append(strArr[0]);
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "the sky    is blue";
        System.out.println(reverseWords(s));
    }
}
