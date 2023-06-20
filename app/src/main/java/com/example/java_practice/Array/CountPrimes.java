package com.example.java_practice.Array;

public class CountPrimes {
    //a prime num is an int greater than 1, and cannot be divided by any int except for 1 and itself

    //brute force
    public int bruteForce(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private boolean isPrime(int x) {
        for (int i = 2; /*i<x*/ i * i < x; i++) {
            if (x % i == 0) {
                //not prime
                return false;
            }
        }
        //is prime
        return true;
    }

    //eratosthenes
    public int eratosthenes(int n) {
        //false == is prime num
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            //composite num must be larger than its divisor
            if (!isPrime[i]) {
                count++;
                //j is composite num
                //composite num must be larger than its divisor, thus here all divisor 'i' related composite numbers = true.
                for (/*int j = 2 * i*/int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

}
