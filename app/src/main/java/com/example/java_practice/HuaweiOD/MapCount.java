package com.example.java_practice.HuaweiOD;

//        题目描述:
//        给定一个字串 s ，找出这样一个子串:
//        1) 该子串中的任意一个字符最多出现2次
//        2)该子串不包含指定某个字符
//        请你找出满足该条件的最长子串的长度
//        输入描述:
//        第一行为要求不包含的指定字符，为单个字符，取值范围[0-9a-zA-ZI第二行为字符串s，每个字符范围[0-9a-zA-Z]，长度范围[1,100001
//        输出描述:
//        个整数，满足条件的最长子串的长度;如果不存在满足条件的子串，则返回0
//
//        示例1
//        输入:
//        D
//        ABC123
//        输出:
//        6
//        示例2
//        输入:
//        D
//        ABACA123D
//        输出:
//        7
//
//        解题思路:
//        1.使用map对象来统计字符出现的次数。
//        2.当出现不包含的字符的时候，记录不包括当前字符的最长值max，清空map。
//        3.当有字符出现次数到达3次的时候(超过2)，对map进行遍历，将出现3次的字符以及它之前的字符全部剔除，记录最长值max。

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().charAt(0);
        String s = sc.nextLine();
        int left = 0;//子串的起始位置
        int max = 0;

        /**
         * key：字符
         * value：字符出现的次数
         */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == c) {
                max = Math.max(max, i - left);
                map.clear();//指定字符之前的数据需要清空
                left = i + 1;//指定字符本身不做计数，所以需要+1
                continue;
            }

            map.put(temp, map.getOrDefault(temp, 0) + 1);
            while (map.get(temp) == 3) {//字符出现第二次之前的字符都需要删除
                char rmStr = s.charAt(left);
                left++;
                max = Math.max(max, i - left + 1);
                map.put(rmStr, map.get(rmStr) - 1);//起始位置后移，字符个数也需要-1
            }
        }
        if (max == 0) {
            max = s.length();
        }

        System.out.println(max);
    }
}
