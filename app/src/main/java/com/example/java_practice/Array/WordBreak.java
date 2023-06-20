package com.example.java_practice.Array;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) return false;
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                if (!dp[j]) continue;
                String substring = s.substring(j, i);
                if (wordDict.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; j++) {
            for (String word : wordDict) {
                int len = word.length();
                if (len <= j && word.equals(s.substring(j - len, j))) {
                    dp[j] = dp[j] || dp[j - len];
                }
            }
        }

        return dp[n];
    }
}
