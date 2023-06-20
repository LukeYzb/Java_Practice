package com.example.java_practice.HuaweiOD;

//描述
//        输出 1到n之间 的与 7 有关数字的个数。
//        一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
//
//        数据范围：
//        1≤n≤30000
//        输入描述：
//        一个正整数 n 。( n 不大于 30000 )
//
//        输出描述：
//        一个整数，表示1到n之间的与7有关的数字个数。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HasSeven {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = bufferedReader.readLine()) != null) {
            int count = 0;
            int num = Integer.parseInt(input);

            for (int i = 7; i <= num; i++) {
                if (i % 7 == 0 || contain7(i)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    public static boolean contain7(int n) {
        while (n > 0) {
            if (n % 10 == 7) {
                return true;
            } else {
                n /= 10;
            }
        }
        return false;
    }
}
