package com.example.java_practice.Array;

public class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return 0;

        int left = search2(nums, target);
        int right = search4(nums, target);

        if (left < 0 || right < 0) return 0;

        return right - left + 1;
    }

    //find index of first target
    int search2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] != target) return -1;

        return left;
    }

    //find index of last target
    int search4(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (nums[left] != target) return -1;

        return left;
    }
}
