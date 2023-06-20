package com.example.java_practice.Array;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int i = 0, j = nums.length - 1;

        while (i < j) {
            if ((nums[i] + nums[j]) > target) {
                j--;
            } else if ((nums[i] + nums[j]) < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[0];
    }

    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return new int[0];
    }
}
