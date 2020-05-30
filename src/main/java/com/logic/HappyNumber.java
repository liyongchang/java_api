package com.logic;

import java.util.HashSet;
import java.util.Set;

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
