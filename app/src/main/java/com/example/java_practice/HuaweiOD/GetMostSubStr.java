package com.example.java_practice.HuaweiOD;

//        题目描述:
//        给定由 [a-z] 26个英文小写字母组成的字符串A和B，其中A中可能存在重复字母，B中不会存在重复字母现从字符串A中按规则挑选一些字母，可以组成字符串B。挑选规则如下:
//        1) 同一个位置的字母只能被挑选一次
//        被挑选字母的相对先后顺序不能改变
//        求最多可以同时从A中挑选多少组能组成B的字符串
//
//        输入描述:
//        输入为2行，第1行输入字符串A，第2行输入字符串B，行首行尾无多余空格其中A、B均由[a-z] 26个英文小写字母组成0<A.length<100，A中可能包含重复字母0<B.length<10，B中不会出现重复字母
//        输出描述:
//        输出1行，包含1个数字，表示最多可以同时从A中挑选多少组能组成B的字符串行末无多余空格
//        补充说明:
//        无需验证输入格式和输入数据合法性
//
//        示例3
//        输入:
//        aabbcxd
//        abcd
//        输出:
//        1
//        说明:
//        从字符串A(“aabbcxd")中挑选一组B("abcd")后，A中剩余字符串为”abx”，无法再挑出"abcd"

import java.util.Scanner;

public class GetMostSubStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strF = sc.nextLine();    //父字符串
        String strS = sc.nextLine();    //子字符串

        char[] chars = strF.toCharArray();  //将父字符串转化为数组

        int indexF = 0;     //父字符串索引
        int indexS = 0;     //子字符串索引
        int count = 0;      //符合的个数

        while (indexF < strF.length()) {
            if (chars[indexF] == strS.charAt(indexS)) {
                chars[indexF] = ' ';    //已经匹配的置为空
                indexS++;
            }
            if (indexS == strS.length()) {    //长度相同则表示符合子串
                indexS = 0;
                indexF = 0;
                count++;
            } else {
                indexF++;   //不符合则匹配下一个字符
            }
        }

        System.out.println(count);
    }
}
