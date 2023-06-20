package com.example.java_practice.Array;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    //quick sort
    public int[] sort(int[] array, int start, int end) {
        //empty input
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }

        //partition
        int zoneIndex = partition(array, start, end);
        if (zoneIndex > start) {
            sort(array, start, zoneIndex - 1);
        }
        if (zoneIndex < end) {
            sort(array, zoneIndex + 1, end);
        }

        return array;
    }

    public int partition(int[] array, int start, int end) {
        //only one element, no need for partition
        if (start == end) {
            return start;
        }
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int zoneIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                zoneIndex++;
                if (i > zoneIndex) {
                    swap(array, i, zoneIndex);
                }
            }
        }

        return zoneIndex;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
