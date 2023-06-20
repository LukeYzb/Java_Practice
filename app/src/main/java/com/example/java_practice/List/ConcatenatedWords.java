package com.example.java_practice.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (wordBreak(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }


    public static boolean wordBreak(String s, Set<String> hashset) {
        if (hashset.isEmpty()) return false;
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                if (!dp[j]) continue;
                String substring = s.substring(j, i);
                if (hashset.contains(substring)) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
