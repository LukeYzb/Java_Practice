package com.example.java_practice.Array;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        int m = 1, sum = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & m) != 0) {
                    res[i]++;
                }
            }

            res[i] = res[i] % 3;
            sum = sum + res[i] * m;
            m = m << 1;
        }

        return sum;
    }
}
