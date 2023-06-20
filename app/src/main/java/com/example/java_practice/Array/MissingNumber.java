package com.example.java_practice.Array;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == mid) l = mid + 1;
            else r = mid;
        }

        return nums[l] == l ? l + 1 : l;
    }
}
