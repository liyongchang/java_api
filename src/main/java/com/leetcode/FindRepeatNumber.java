package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i : nums) {
            if (list.contains(i)) {
                return i;
            }
            list.add(i);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - i; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int temp;
        for (int i = 0; i < length; i++) {
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
