package com.example.java_practice.Array;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] temp = new int[k];
        for (int i = 0, nums1Index = 0, nums2Index = 0; i < k; i++) {
            if (nums1Index >= m) {
                temp[i] = nums2[nums2Index++];
            } else if (nums2Index >= n) {
                temp[i] = nums1[nums1Index++];
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                temp[i] = nums1[nums1Index++];
            } else {
                temp[i] = nums2[nums2Index++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }
}
