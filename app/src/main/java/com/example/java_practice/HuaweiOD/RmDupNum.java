package com.example.java_practice.HuaweiOD;

//描述
//        输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
//        保证输入的整数最后一位不是 0 。
//
//        数据范围：
//        1≤n≤10^8
//
//        输入描述：
//        输入一个int型整数
//
//        输出描述：
//        按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

import java.io.InputStream;

public class RmDupNum {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        int available = in.available() - 1;
        char[] chars = new char[available];

        while (available-- > 0) {
            chars[available] = (char) in.read();
        }
        StringBuilder resul = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (resul.lastIndexOf(String.valueOf(chars[i])) != -1) {
                continue;
            }
            resul.append(chars[i]);
        }

        System.out.println(resul.toString());
    }
}
