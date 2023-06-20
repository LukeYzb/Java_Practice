package com.example.java_practice.Array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }

        int x = nums[0];
        int sum = 1;

        for (int i = 1; i < nums.length; i++) {
            if (sum == 0) {
                x = nums[i];
                sum = 1;
            } else {
                if (x == nums[i]) {
                    sum++;
                } else {
                    sum--;
                }
            }
        }

        return x;
    }
}
