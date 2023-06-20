package com.example.java_practice.Array;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        int res = 1;

        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int k = map.get(s.charAt(i));
                dp[i] = i - k <= dp[i - 1] ? i - k : dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
            map.put(s.charAt(i), i);
        }

        return res;
    }
}
