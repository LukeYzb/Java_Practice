package com.example.java_practice.HuaweiOD;

//描述
//        输入一个整数，将这个整数以字符串的形式逆序输出
//        程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
//
//
//        数据范围：
//        0≤n≤(2^30)−1
//        输入描述：
//        输入一个int整数
//
//        输出描述：
//        将这个整数以字符串的形式逆序输出

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int a = 0;
        int num = Integer.parseInt(str);

        do {
            a = num % 10;
            num = num / 10;
            System.out.print(a);
        } while (num > 0);
    }
}
