package com.example.java_practice.Array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        List<Integer> res = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            while (true) {
                int temp = nums[i];
                if (temp <= 0 || temp == nums[temp - 1] && temp != i + 1) {
                    nums[i] -= len;
                    break;
                } else if (temp == nums[temp - 1]) {
                    break;
                }
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    //better
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
