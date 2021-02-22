package com.leetcode;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int salary = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                salary = Math.max(prices[i] - min, salary);
            } else {
                min = prices[i];
            }
        }
        return salary;
    }
}
