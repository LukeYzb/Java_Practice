package com.example.java_practice.Array;

public class MinArray {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] < numbers[r]) {
                return numbers[l];
            }

            int mid = (r + l) / 2;
            if (numbers[mid] > numbers[l]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[l]) {
                r = mid;
            } else {
                l++;
            }
        }

        return numbers[l];
    }
}
