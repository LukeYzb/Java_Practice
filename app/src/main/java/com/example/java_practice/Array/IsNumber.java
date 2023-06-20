package com.example.java_practice.Array;

public class IsNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }

        char[] res = s.trim().toCharArray();
        if (res.length <= 0) return false;

        int n = res.length;

        boolean is_dot = false, is_e_or_E = false, is_num = false;
        for (int i = 0; i < n; i++) {
            if (res[i] >= '0' && res[i] <= '9') {
                is_num = true;
            } else if (res[i] == '.') {
                //before it: there should be no dot or 'e' or 'E'
                if (is_dot || is_e_or_E) {
                    return false;
                }
                is_dot = true;
            } else if (res[i] == 'e' || res[i] == 'E') {
                //before it: there should be a num, no 'e' or 'E'
                if (!is_num || is_e_or_E) {
                    return false;
                }
                is_e_or_E = true;
                is_num = false;//11E+
            } else if (res[i] == '-' || res[i] == '+') {
                if (i != 0 && res[i - 1] != 'e' && res[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return is_num;
    }
}
