package com.example.java_practice.Array;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;

        //if input is empty, return length==0
        if (l == 0 || l == 1) {
            return l;
        }

        int res = 0;//result length

        //create result array without duplicate, count its length
        for (int i = 1; i < l; i++) {
            if (nums[res] != nums[i]) {
                res++;
                nums[res] = nums[i];
            }
        }

        return res + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int l = nums.length;

        //if input is empty, return length==0
        if (l == 0 || l == 1) {
            return l;
        }

        int[] nums1 = new int[l];//result array
        nums1[0] = nums[0];
        int res = 0;//result length

        //create result array without duplicate, count its length
        for (int i = 1; i < l; i++) {
            if (nums1[res] != nums[i]) {
                nums1[res + 1] = nums[i];
                res++;
            }
        }
        //modify original array
        for (int i = 1; i < res + 1; i++) {
            nums[i] = nums1[i];
        }

        return res + 1;
    }
}
