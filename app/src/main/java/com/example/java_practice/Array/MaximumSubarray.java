package com.example.java_practice.Array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //decide whether to start a new subarray
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //store the largest subarray sum
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
