package com.example.java_practice.HuaweiOD;

//描述
//        •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
//
//        •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
//        输入描述：
//        连续输入字符串(每个字符串长度小于等于100)
//
//        输出描述：
//        依次输出所有分割后的长度为8的新字符串

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            int len = str.length();
            int start = 0;

            //each word len should be 8, add 0 if less than 8
            while (len >= 8) {
                System.out.println(str.substring(start, start + 8));
                start += 8;
                len -= 8;
            }
            if (len > 0) {
                char[] tmp = new char[8];

                for (int i = (str.length() - start); i < tmp.length; i++) {
                    tmp[i] = '0';
                }
                for (int i = 0; start < str.length(); i++) {
                    tmp[i] = str.charAt(start++);
                }
                System.out.println(String.valueOf(tmp));
            }
        }
    }
}
