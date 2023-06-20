package com.example.java_practice.HuaweiOD;

//描述
//        给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
//        所谓回文串，指左右对称的字符串。
//        所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
//        数据范围：字符串长度
//        1≤s≤350
//
//        进阶：时间复杂度：
//        O(n) ，
//        空间复杂度：
//        O(n)
//        输入描述：
//        输入一个仅包含小写字母的字符串
//
//        输出描述：
//        返回最长回文子串的长度

import java.io.*;

public class LongestSubPalindrome {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = br.readLine()) != null) {
            int ans = 0;
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                ans = Math.max(ans, way(c, i, i));
                if (i > 0) {
                    ans = Math.max(ans, way(c, i - 1, i));
                }
            }

            System.out.println(ans);
        }
    }

    public static int way(char[] c, int left, int right) {
        while (left >= 0 && right < c.length && c[left] == c[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
