package com.example.java_practice;

public class CuttingRope1 {
    //https://leetcode.cn/problems/jian-sheng-zi-lcof/solution/jian-sheng-zi-by-leetcode-solution-xku9/
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
