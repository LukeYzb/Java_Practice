package com.example.java_practice;

public class CuttingRope2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        int p = 1000000007;
        if (remainder == 0) {
            return (int) pow(3, quotient);
        } else if (remainder == 1) {
            return (int) (pow(3, quotient - 1) * 4 % p);
        } else {
            return (int) (pow(3, quotient) * 2 % p);
        }
    }

    //a^n %p
    long pow(int a, int n) {
        long res = 1;
        int p = 1000000007;
        for (int i = 1; i <= n; i++) {
            res = (res * a) % p;
        }

        return res;
    }
}
