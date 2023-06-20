package com.example.java_practice;

public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }

        long bit = 1, count = 9;
        int i = 1;

        while (count < n) {
            n = (int) (n - count);
            bit = bit * 10;
            i++;
            count = bit * i * 9;
        }
        //get index range
        long num = bit + (n - 1) / i;
        //get word
        int index = (n - 1) % i + 1;
        int res = (int) ((num / Math.pow(10, i - index)) % 10);

        return res;
    }
}
