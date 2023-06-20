package com.example.java_practice.Array;

import java.lang.reflect.Array;

public class FindTheMiddleIndexInArray {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int total = 0;
        //method1
//        for (int i = 0; i < nums.length; i++) {
//            total += nums[i];
//            if (total == sum) {
//                return i;
//            }
//            sum -= nums[i];
//        }
        //method2
        for (int i = 0; i < nums.length; i++) {
            if (2 * total + nums[i] == sum) {
                return i;
            }
            total += nums[i];
        }

        return -1;
    }
}
