package com.leetcode;

public class MergeTwoSortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] newSort = new int[m + n];
        while (p1 < m || p2 < n) {
            int cur;
            if (p1 == m) {
                cur = nums2[p2];
                p2++;
            } else if (p2 == n) {
                cur = nums1[p1];
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1];
                p1++;
            } else {
                cur = nums2[p2];
                p2++;
            }
            newSort[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = newSort[i];
        }
    }

    public static void main(String[] args) {
        int[] newSort = new int[2];
        newSort[0] = 10;
        newSort[1] = 11;

        int p1 = 0;
        System.out.println(newSort[p1++]);


    }
}
