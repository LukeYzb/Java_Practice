package com.example.java_practice.HuaweiOD;

//描述
//        分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
//        注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
//        如有多个解，请输出任意一个。
//
//
//        输入描述：
//        输入一个真分数，String型
//
//        输出描述：
//        输出分解后的string

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EgyptianFraction {
    public static void main(String[] args) throws IOException {
        fx();
    }

    //将真分数分解为埃及分数
    private static void fx() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = bf.readLine()) != null) {
            String[] input = str.split("/");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (a > b || a < 1 || b < 2) break;
            while (a != 1) {
                if (b % a == 0) {
                    b = b / a;
                    a = 1;
                    continue;
                }
                if (b % (a - 1) == 0) {
                    System.out.print("1/" + b / (a - 1) + "+");
                    a = 1;
                } else {
                    int c;
                    c = b / a + 1;
                    a = a - b % a;
                    b = b * c;
                    System.out.print("1/" + c + "+");
                }

            }
            System.out.println("1/" + b);
        }
        bf.close();
    }
}
