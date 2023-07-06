package com.example.java_practice.HuaweiOD;

//    题目描述：
//    定义字符串完全由'A'和'B'组成，也可以全是'A'或'B'。
//    给出一个字符串s，允许将字符串中任何的'A'或'B'改为'B'或'A'，求可以使s满足字典序排列的最小修改次数。
//    0<s.length<100000
//
//    示例1
//    输入：
//    AABBA
//    输出：
//    1
//    修改最后一位得AABBB。

import java.util.Scanner;

public class AscStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();

        int min = 0;
        int countB = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'B') {
                //假设之前的子字符串经过修改已满足要求，当前位置的B并不会使字典序变化，只统计B的个数
                countB++;
            }
            if (string.charAt(i) == 'A') {
                //方案1 : 把所有之前的B改为A
                int candidate1 = countB;

                //方案2：假设在当前位置以前的子字符串经过修改已满足要求，当前位置的A一般改为B，即使不需要也有min兜着,即动态编程思想
                int candidate2 = min + 1;

                min = Math.min(candidate1, candidate2);
            }
        }

        System.out.println(min);
    }
}
