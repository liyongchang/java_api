package com.leetcode;

public class Fib {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */

    public static void main(String[] args) {
        System.out.println(fib1(5));
    }

    public static Integer fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static Integer fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res1 = 0;
        int res2 = 1;
        for (int i = 1; i < n; i++) {
            int tem = (res1 + res2)%1000000007;
            res1 = res2;
            res2 = tem;
        }
        return res2;
    }

}
