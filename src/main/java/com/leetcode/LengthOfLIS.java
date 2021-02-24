package com.leetcode;

public class LengthOfLIS {
    public static void main(String[] args) {
        LIS(new int[]{1, 2, 1});
    }

    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS(int[] arr) {
        // write code here
        int[] nums = new int[arr.length];
        int[] temp = new int[arr.length];
        nums[0] = 1;
        int tempIndex = 0;
        temp[tempIndex] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int left = 0, right = tempIndex;
            if (arr[i] > temp[tempIndex]) {
                tempIndex++;
                nums[i] = tempIndex + 1;
                temp[tempIndex] = arr[i];
            } else {
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (temp[mid] > arr[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                temp[left] = arr[i];
                nums[i] = left + 1;
            }
        }
        int[] res = new int[tempIndex + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == tempIndex + 1) {
                res[tempIndex] = arr[i];
                tempIndex--;
            }
        }
        return res;
    }

}
