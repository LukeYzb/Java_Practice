package com.example.java_practice;

public class CountDigitOne {
    public int countDigitOne(int n) {
        long bit = 1;
        int sum = 0;
        while (bit <= n) {
            long cur = (n / bit) % 10, low = n % bit, high = n / bit / 10;
            if (cur > 1) {
                sum += (high + 1) * bit;
            } else if (cur == 1) {
                sum += (high * bit) + (1 + low);
            } else {
                sum += high * bit;
            }
            bit = bit * 10;
        }

        return sum;
    }
}
