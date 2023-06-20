package com.example.java_practice.HuaweiOD;

//描述
//        IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
//
//        现在需要你用程序来判断IP是否合法。
//
//        数据范围：数据组数：
//        1≤t≤18
//
//        进阶：时间复杂度：
//        O(n) ，空间复杂度：
//        O(n)
//
//        输入描述：
//        输入一个ip地址，保证不包含空格
//
//        输出描述：
//        返回判断的结果YES or NO

import java.io.*;

public class LegalIP {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bf.readLine()) != null) {
            String[] subIP = str.split("\\.");

            if (subIP.length != 4) {
                System.out.println("NO");
                break;
            }
            for (int i = 0; i < subIP.length; i++) {
                if (subIP[i] == null || subIP[i].equals("") || (subIP[i].length() != 1 && subIP[i].substring(0, 1).equals("0")) || !subIP[i].matches("[0-9]+")) {
                    System.out.println("NO");
                    break;
                }
                Integer intIP = Integer.valueOf(subIP[i]);
                if (intIP >= 0 && intIP <= 255) {
                    if (i == subIP.length - 1) {
                        System.out.println("YES");
                    }
                    continue;
                } else {
                    System.out.println("NO");
                    break;
                }
            }
        }
    }
}
