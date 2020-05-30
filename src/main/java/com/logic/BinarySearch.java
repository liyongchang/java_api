package com.logic;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 9, 3, 5, 8 };
		Arrays.sort(arr);
		int index=Arrays.binarySearch(arr, 3);
		System.out.println("数组排序后3的索引是"+index);

	}
}
