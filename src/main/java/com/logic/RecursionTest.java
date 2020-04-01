package com.logic;

public class RecursionTest {

	/*
	 * 用递归编写程序时一定要牢记两点：
	 * 1. 递归公式；
	 * 2. 收敛条件（什么时候就不再继续递归）。
	 * recursive function calling
	 */
	public static String reverse(String originStr) {
		if (originStr == null || originStr.length() <= 1)
			return originStr;
		System.out.println(originStr);
		System.out.println(originStr.substring(1));
		System.out.println(originStr.charAt(0));
		System.out.println(reverse(originStr.substring(1)) + originStr.charAt(0));
		System.out.println("............");
		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}

	public static void main(String[] args) {
		String s = reverse("123456");
		System.out.println(s);
	}

}
