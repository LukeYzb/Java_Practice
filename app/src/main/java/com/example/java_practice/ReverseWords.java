package com.example.java_practice;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        s = s.trim();
        StringBuilder builder = new StringBuilder();
        int i = s.length() - 1, j = i;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            builder.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }

        return builder.toString().trim();
    }
}
