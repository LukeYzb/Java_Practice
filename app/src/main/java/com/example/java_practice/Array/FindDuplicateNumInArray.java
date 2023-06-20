package com.example.java_practice.Array;

public class FindDuplicateNumInArray {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int k = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = k;
            }
        }

        return -1;
    }
}
