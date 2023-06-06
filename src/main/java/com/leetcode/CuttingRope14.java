package com.leetcode;

/**
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 我们总是从解决最小问题开始，并把已经解决的子问题的最优解存储下来，并把子问题的最优解组合起来逐步解决大的问题。
 * https://www.cnblogs.com/qujingtongxiao/p/12689334.html
 * 因为有取模的操作，动态规划中max
 * 不能用了，我们观察：正整数从1开始，但是1不能拆分成两个正整数之和，所以不能当输入。
 * 2只能拆成 1+1，所以乘积也为1。
 * 数字3可以拆分成 2+1 或 1+1+1，显然第一种拆分方法乘积大为2。
 * 数字4拆成 2+2，乘积最大，为4。
 * 数字5拆成 3+2，乘积最大，为6。
 * 数字6拆成 3+3，乘积最大，为9。
 * 数字7拆为 3+4，乘积最大，为 12。
 * 数字8拆为 3+3+2，乘积最大，为 18。
 * 数字9拆为 3+3+3，乘积最大，为 27。
 * 数字10拆为 3+3+4，乘积最大，为 36。
 * 那么通过观察上面的规律，我们可以看出从5开始，数字都需要先拆出所有的3，一直拆到剩下一个数为2或者4，因为剩4就不用再拆了，拆成两个2和不拆没有意义，而且4不能拆出一个3剩一个1，这样会比拆成 2+2 的乘积小。
 */
public class CuttingRope14 {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 3;
        }
        int[] dp = new int[n + 1];
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }


    public int cuttingRope2(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public static void main(String[] args) {
        CuttingRope14 cuttingRope14=new CuttingRope14();
        System.out.println(cuttingRope14.cuttingRope2(5));
    }

}
