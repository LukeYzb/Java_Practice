package com.example.java_practice.HuaweiOD;

//描述
//        查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
//        注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
//
//        数据范围：字符串长度
//        1≤length≤300
//
//        进阶：时间复杂度：
//        O(n^3) ，
//        空间复杂度：
//        O(n)
//
//        输入描述：
//        输入两个字符串
//
//        输出描述：
//        返回重复出现的字符

import java.io.*;

public class LongestSubString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            String ss = br.readLine();
            if (str.length() < ss.length()) {
                System.out.println(res(str, ss));
            } else {
                System.out.println(res(ss, str));
            }
        }
    }

    public static String res(String s, String c) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = c.toCharArray();
        int[][] ins = new int[ch1.length + 1][ch2.length + 1];
        int max = 0;
        int start = 0;

        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    ins[i + 1][j + 1] = ins[i][j] + 1;
                    if (ins[i + 1][j + 1] > max) {
                        max = ins[i + 1][j + 1];
                        start = i - max;
                    }
                }
            }
        }

        return s.substring(start + 1, start + max + 1);
    }
}
