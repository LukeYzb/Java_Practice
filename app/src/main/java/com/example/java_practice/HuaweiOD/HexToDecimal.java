package com.example.java_practice.HuaweiOD;

//描述
//        写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
//
//        数据范围：保证结果在
//        1≤n≤(2^31)−1
//        输入描述：
//        输入一个十六进制的数值字符串。
//
//        输出描述：
//        输出该数值的十进制字符串。不同组的测试用例用\n隔开。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HexToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = bf.readLine()) != null) {
            String temp = input.substring(2, input.length());
            int sum = 0;
            int length = temp.length();

            for (int i = length - 1; i >= 0; i--) {
                char c = temp.charAt(i);
                int tempNum = (int) c;

                if (tempNum >= 65) {
                    tempNum = tempNum - 65 + 10;
                } else {
                    tempNum = tempNum - 48;
                }
                sum = sum + (int) Math.pow(16, length - i - 1) * tempNum;
            }
            System.out.println(sum);
        }
    }
}
