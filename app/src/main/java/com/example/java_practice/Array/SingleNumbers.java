package com.example.java_practice.Array;

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int z = 0;
        for (int i = 0; i < nums.length; i++) {
            z = z ^ nums[i];
        }

        int m = 1;
        while ((m & z) == 0) {
            m = m << 1;
        }

        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & m) == 0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }

        return new int[]{x, y};
    }
}
