package com.example.java_practice.Array;

import java.util.Arrays;

//time complexity: O(n)
//space complexity: O(nlogk)
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length <= 0 || k <= 0) {
            return new int[0];
        }

        return quickFind(arr, 0, arr.length - 1, k);
    }

    int[] quickFind(int[] arr, int left, int right, int k) {
        int i = partition(arr, left, right);

        if (i + 1 == k) {
            return Arrays.copyOf(arr, k);
        }
        if (i + 1 > k) {
            return quickFind(arr, 0, i - 1, k);
        } else {
            return quickFind(arr, i + 1, right, k);
        }
    }

    int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        int i = left + 1;
        int j = right;

        while (i < j) {
            while (i <= j && arr[i] <= pivot) i++;
            while (i <= j && arr[j] >= pivot) j--;
            if (i >= j) {
                break;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[left] = arr[j];
        arr[j] = pivot;

        return j;
    }
}
