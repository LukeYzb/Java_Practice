package com.example.java_practice.Array;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (right - left) / 2 + left;
        int x1 = mergeSort(nums, left, mid);
        int x2 = mergeSort(nums, mid + 1, right);
        int x3 = merge(nums, left, mid, mid + 1, right);

        return x1 + x2 + x3;
    }

    int merge(int[] nums, int l1, int r1, int l2, int r2) {
        int[] tmp = new int[r2 - l1 + 1];
        int count = 0, i = l1, j = l2, k = 0;
        while (i <= r1 && j <= r2) {
            if (nums[i] > nums[j]) {
                count += l2 - i;
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        while (i <= r1) tmp[k++] = nums[i++];
        while (j <= r2) tmp[k++] = nums[j++];

        k = 0;
        for (int l = l1; l <= r2; l++) {
            nums[l] = tmp[k++];
        }

        return count;
    }
}
