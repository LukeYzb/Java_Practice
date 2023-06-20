package com.example.java_practice.HuaweiOD;

//        题目描述:
//        个图像有n个像素只点，存储在一个长度为n的数组img里，每个像素点的取值范围[0,255]的正整数。请你给图像每个像素点值加上一个整数k (可以是负数)，得到新图newlmg，使得新图newlmg的所有像素平均值最接近中位值128
//        请输出这个整数k。
//
//        输入描述:
//        n个整数，中间用空格分开
//        例如:
//        0000
//        4个数值，中间用空格分开
//        输出描述
//        个整数k
//        补充说明:
//        1 <= n <= 100
//        如有多个整数k都满足，输出小的那个k;
//        新图的像素值会自动截取到[0,255]范围。当新像素值<0，其值会更改为0;当新像素值>255，其值会更改为255
//
//        示例1
//        输入:0000
//        输出:
//        128
//        说明:
//        四个像素值都为0
//        示例2输入:
//        129 130 129 130
//        输出:
//        说明:
//        -1的均值128.5，-2的均值为127.5，输出较小的数-2
//
//        解题思路:
//        1.求输入数组的值的总和
//        2.求出数组的平均值(使用double保留小数)
//        3.平均值- 128 求出其差值
//        4.如果差值是小数则需要进行四舍五入
//        5.需要考虑到newlmg的值小于0或大于255
//        6.需要对步骤4的数字进行取反

import java.util.Arrays;
import java.util.Scanner;

public class AutomaticExposure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(" ");
        int len = strs.length;

        double count = 0;   //输入值总和
        for (int i = 0; i < len; i++) {
            int num = Integer.valueOf(strs[i]);
            count += num;
        }

        double averages = count / len - 128;  //平均差
        int res;
        if (averages >= 0) {
            res = (int) Math.round(averages);   //对平均差进行四舍五入
        } else {
            res = (int) (-Math.round(-averages));
        }

        int lessThanZeroNum = 0;    //newImg小于0的个数
        int lessThanZero = 0;    //newImg小于0的与0的差值的和
        for (int i = 0; i < len; i++) {
            int num = Integer.valueOf(strs[i]);
            if (num - res < 0) {    //考虑到newImg的值小于0
                lessThanZeroNum++;
                lessThanZero += num - res - 0;
            }
        }
        res -= lessThanZero / (len - lessThanZeroNum);

        int largeThanTwoFiveFiveNum = 0;    //newImg大于255的个数
        int largeThanTwoFiveFive = 0;    //newImg大于255的与255的差值的和
        for (int i = 0; i < len; i++) {
            int num = Integer.valueOf(strs[i]);
            if (num - res > 255) {    //考虑到newImg的值大于255
                largeThanTwoFiveFiveNum++;
                largeThanTwoFiveFive += num - res - 255;
            }
        }
        res -= largeThanTwoFiveFive / (len - largeThanTwoFiveFiveNum);

        System.out.println(0 - res);    //取反
    }
}

class AutomaticExposure1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strings = in.nextLine().split(" ");
        int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        solution(nums);
    }

    public static void solution(int[] list) {
        int ans = 0;
        int t = Integer.MAX_VALUE;

        for (int i = -127; i < 255/*129*/; ++i) {
            int sum = 0;
            for (int j = 0; j < list.length; ++j) {
                int tmp = i + list[j];
                if (tmp < 0) {
                    tmp = 0;
                } else if (tmp > 255) {
                    tmp = 255;
                }
                sum += tmp;
            }
            if (t > Math.abs(128 * list.length - sum)) {
                ans = i;
                t = Math.abs(128 * list.length - sum);
            }
        }

        System.out.println(ans);
    }
}
