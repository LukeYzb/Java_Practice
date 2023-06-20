package com.example.java_practice;

public class MyPow {
    public double myPow(double x, int n) {
        double res = 1;
        long y = n;//use long cause the minimum value may exceed int range

        if (n < 0) {
            y = -y;
            x = 1 / x;
        }
        while (y > 0) {
            if (y % 2 == 1) {
                res = res * x;
            }

            x = x * x;
            y = y / 2;
        }

        return res;
    }
}
