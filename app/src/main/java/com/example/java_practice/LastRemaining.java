package com.example.java_practice;

public class LastRemaining {
    public int lastRemaining(int n, int m) {
        if (n <= 0) return n;

        int res = 1;

        for (int i = 1; i <= n; i++) {
            res = (res + m) % i;
        }

        return res;
    }
}
