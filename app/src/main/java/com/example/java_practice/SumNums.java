package com.example.java_practice;

public class SumNums {
    int sum = 0;

    public int sumNums(int n) {
        boolean flag = n >= 1 && sumNums(n - 1) < 1;
        sum += n;
        return sum;
    }

    public int sumNums1(int n) {
        if (n <= 0) {
            return 0;
        }

        return sumNums(n - 1) + n;
    }
}
