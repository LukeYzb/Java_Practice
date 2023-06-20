package com.example.java_practice.Array;

import java.util.HashSet;
import java.util.Set;

public class IsStraight {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1, min = 20;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (set.contains(nums[i])) return false;
            set.add(nums[i]);
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        return max - min < 5;
    }
}
