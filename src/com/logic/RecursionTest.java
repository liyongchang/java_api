package com.logic;

public class RecursionTest {

	/*
	 * �õݹ��д����ʱһ��Ҫ�μ����㣺
	 * 1. �ݹ鹫ʽ��
	 * 2. ����������ʲôʱ��Ͳ��ټ����ݹ飩��
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
