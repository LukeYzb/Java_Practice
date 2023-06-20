package com.example.java_practice.HuaweiOD;

//描述
//        接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
//
//        输入描述：
//        输入一行，为一个只包含小写字母的字符串。
//
//        输出描述：
//        输出该字符串反转后的字符串。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWord {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        System.out.println(new StringBuffer(string).reverse());
    }
}
