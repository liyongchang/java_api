package com.leetcode.reverse;

public class ReverseIntNumber {
    // TODO: 2021/3/18
    public static void main(String[] args) {
        System.out.println(reverseLeftWords(12345));
    }

    /**
     * 求余运算%,巧妙
     * 123
     * 第一轮：
     * res 10*0+3 =3
     * s=12
     *   * 第2轮：
     *      * res 10*3+2 =32
     *      * s=2
     *      *   * 第3轮：
     *      *      * res 10*32+1 =321
     *      *      * s=0
     *
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