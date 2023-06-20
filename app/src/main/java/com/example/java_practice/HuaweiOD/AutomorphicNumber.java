package com.example.java_practice.HuaweiOD;

//描述
//        自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n(包括n)以内的自守数的个数
//
//        数据范围：
//        1≤n≤10000

import java.io.*;

public class AutomorphicNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while ((str = br.readLine()) != null) {
            int n = Integer.valueOf(str);
            int count = 0;
            for (int i = 0; i <= n; i++) {
                int temp = i;
                int j = 1;
                //get the digits of Automorphic Number
                while (temp != 0) {
                    temp = temp / 10;
                    j = j * 10;
                }
                if ((i * i - i) % j == 0) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
