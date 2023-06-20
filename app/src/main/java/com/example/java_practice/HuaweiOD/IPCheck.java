package com.example.java_practice.HuaweiOD;

//描述
//        请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
//
//        所有的IP地址划分为 A,B,C,D,E五类
//
//        A类地址从1.0.0.0到126.255.255.255;
//
//        B类地址从128.0.0.0到191.255.255.255;
//
//        C类地址从192.0.0.0到223.255.255.255;
//
//        D类地址从224.0.0.0到239.255.255.255；
//
//        E类地址从240.0.0.0到255.255.255.255
//
//
//        私网IP范围是：
//
//        从10.0.0.0到10.255.255.255
//
//        从172.16.0.0到172.31.255.255
//
//        从192.168.0.0到192.168.255.255
//
//
//        子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
//        （注意二进制下全是1或者全是0均为非法子网掩码）
//
//        注意：
//        1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
//        2. 私有IP地址和A,B,C,D,E类地址是不冲突的
//
//        输入描述：
//        多行字符串。每行一个IP地址和掩码，用~隔开。
//
//        请参考帖子https://www.nowcoder.com/discuss/276处理循环输入的问题。
//        输出描述：
//        统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IPCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, pri = 0;

        while ((str = buffer.readLine()) != null) {
            int index = str.indexOf('~');
            long num1 = strToInt(str.substring(0, index));
            long num2 = strToInt(str.substring(index + 1));
            long t = num1 >> 24;

            if (t == 0 || t == 127) continue;
            if (num2 <= 0 || num2 >= 0XFFFFFFFFL || (((num2 ^ 0XFFFFFFFFL) + 1) | num2) != num2) {
                err++;
                continue;
            }
            if (t <= 0) err++;
            else if (t >= 1 && t <= 126) {
                a++;
                if (t == 10) pri++;
            } else if (t >= 128 && t <= 191) {
                b++;
                if (num1 >> 20 == 0xAC1) pri++;
            } else if (t >= 192 && t <= 223) {
                c++;
                if (num1 >> 16 == 0xC0A8) pri++;
            } else if (t >= 224 && t <= 239) d++;
            else if (t >= 240 && t <= 255) e++;
        }

        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + pri);
    }

    public static long strToInt(String str) {
        char[] cs = str.toCharArray();
        long res = 0, tmp = 0, flag = 0;

        for (char c : cs) {
            if (c == '.') {
                res = res << 8 | tmp;
                tmp = 0;
                flag++;
            } else if (c >= '0' && c <= '9') {
                tmp = tmp * 10 + c - '0';
                flag = 0;
            } else {
                return -1;
            }
            if (flag >= 2) return -1;

        }
        res = res << 8 | tmp;

        return res;
    }
}
