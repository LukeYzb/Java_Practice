package com.example.java_practice.Array;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int a = 1, b = 1, c = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }

        return dp[n];
    }
}
