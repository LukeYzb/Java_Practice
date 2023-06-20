package com.example.java_practice;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 *
 * @return a random integer in the range 1 to 7
 */
public class ImplementRand10UsingRand7 {
    public int rand10() {
        int temp = 40;
        while (temp >= 40) {
            temp = (rand7() - 1) * 7 + rand7() - 1;
        }
        return temp % 10 + 1;
    }

    public int rand7() {
        return (int) (Math.random() * 6) + 1;
    }
}
