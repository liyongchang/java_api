package com.leetcode;

public class MaxProfitII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int salary = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                salary += prices[i] - prices[i - 1];
            }
        }
        return salary;
    }

    public static void main(String[] args) {
        MaxProfitII maxProfitII = new MaxProfitII();
        System.out.println(maxProfitII.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
