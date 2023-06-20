package com.example.java_practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s == null || s.length() <= 0) {
            return ' ';
        }

        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }

        for (Map.Entry<Character, Boolean> m : map.entrySet()
        ) {
            if (m.getValue()) {
                return m.getKey();
            }
        }

        return ' ';
    }
}
