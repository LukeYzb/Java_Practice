package com.example.java_practice.Array;

public class TranslateNum {
    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }

        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            //get types of combination in i~i-1
            int tmp = 10 * (arr[i - 2] - '0') + (arr[i - 1] - '0');
            if (tmp >= 10 && tmp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n];
    }
}
