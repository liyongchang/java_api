package com.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

	public static void main(String[] args) {
		boolean result=isHappy(19);
		System.out.println(result);
	}

	public static boolean isHappy(int n) {
		Set<Integer> inLoop = new HashSet<Integer>();
		int squareSum, remain;
		while (inLoop.add(n)) {
			squareSum = 0;
			while (n > 0) {
				//余数
				remain = n % 10;
				squareSum += remain * remain;
				//取整数
				n /= 10;
			}
			if (squareSum == 1)
				return true;
			else
				n = squareSum;

		}
		return false;

	}
}
