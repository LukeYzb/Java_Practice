package com.example.java_practice.HuaweiOD;

//        题目描述:
//        工位由序列F1,F2...Fn组成，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物
//        1、某一空位的友好度为左右连续老员工数之和
//        2、为方便新员工学习求助，优先安排友好度高的空位
//        给出工位序列，求所有空位中友好度的最大值
//        输入描述:
//        第一行为工位序列: F1,F2...F组成，1<=n<=100000，Fi值为0、1或2。其中0代表空置，1代码有人，2代表障碍物其中0代表空置，1代码有人，2代表障碍物。
//        输出描述:
//        所有空位中友好度的最大值。如果没有空位，返回0。
//
//        示例1
//        输入:
//        1 1 0 1 2 1 0
//        输出:
//        3
//        说明:
//        第3个位置友好度为3。因障碍物隔断，左边得2分，右边只能得1分。

import java.util.Scanner;

public class NewStaffSeatArrangement {
    public static void main(String[] args) {
        int max = 0, left = 0, right = 0;//left and right are for xu[i+1]
        Scanner sc = new Scanner(System.in);
        String[] xu = sc.nextLine().split(" ");

        for (int i = 0; i < xu.length; i++) {
            if (xu[i].equals("1")) {
                left++;
            } else if (xu[i].equals("2")) {
                left = 0;
            } else if (xu[i].equals("0")) {
                for (int j = i + 1; j < xu.length; j++) {
                    if (xu[j].equals("1")) {
                        right++;
                    } else if (xu[j].equals("0") || xu[j].equals("2")) {
                        break;
                    }
                }
                if (max < left + right) {
                    max = left + right;
                }
                right = 0;
                left = 0;
            }
        }

        System.out.println(max);
    }
}
