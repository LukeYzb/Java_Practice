package com.example.java_practice;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();

        for (int i = n; i < len + n; i++) {
            builder.append(s.charAt(i % len));
        }

        return builder.toString();
    }
}
