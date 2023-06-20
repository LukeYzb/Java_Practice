package com.example.java_practice.Array;

public class Fib {
    //f(0)=0; f(1)=1; f(n)=f(n-1)+f(n-2), n>1

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, c = 0;

        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }

        return c;
    }


    int[] arr;

    public int fib1(int n) {
        arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        return f(n);
    }

    int f(int n) {
        if (n <= 1) {
            return n;
        }

        if (arr[n] != -1) {
            return arr[n];
        }

        int sum = (f(n - 1) + f(n - 2)) % 1000000007;
        arr[n] = sum;
        return sum;
    }

}
