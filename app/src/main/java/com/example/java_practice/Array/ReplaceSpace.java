package com.example.java_practice.Array;

public class ReplaceSpace {
    public String replaceSpace(String s) {
//        //normal solution
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') {
//                stringBuilder.append("%20");
//            } else {
//                stringBuilder.append(s.charAt(i));
//            }
//        }
//
//        return stringBuilder.toString();


        //better solution
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }

        //expand more space for "%20"
        char[] res = new char[s.length() + count * 2];
        int k = res.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                res[k--] = '0';
                res[k--] = '2';
                res[k--] = '%';
            } else {
                res[k--] = s.charAt(i);
            }
        }

        return new String(res);
    }
}
