package com.example.java_practice.HuaweiOD;

//描述
//        验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
//
//        例如：
//
//        1^3=1
//
//        2^3=3+5
//
//        3^3=7+9+11
//
//        4^3=13+15+17+19//从n*(n-1)+1开始的n个连续递增奇数
//
//        输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
//        数据范围：
//        1≤m≤100
//
//        进阶：时间复杂度：
//        O(m) ，
//        空间复杂度：
//        O(1)
//
//        输入描述：
//        输入一个int整数
//
//        输出描述：
//        输出分解后的string

import java.io.*;

public class NicochsTheorem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
//            System.out.println(method(num));

            //从n*(n-1)+1开始的n个连续递增奇数
            StringBuffer sb = new StringBuffer();
            int temp = (num * (num - 1)) + 1;
            for (int i = 1; i <= num; i++) {
                sb.append(temp).append("+");
                temp += 2;
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

//    public static String method(int m) {
//        int temp2 = m * m;
//        StringBuffer sb = new StringBuffer();
//
//        for (int i = 0; i < m; i++) {
//            if (m % 2 != 0) {
//                sb.append(temp2 - 2 * (m / 2) + 2 * i).append("+");
//            } else {
//                sb.append(temp2 - m + 1 + 2 * i).append("+");
//                ;
//            }
//        }
//        return sb.substring(0, sb.length() - 1);
//    }
}
