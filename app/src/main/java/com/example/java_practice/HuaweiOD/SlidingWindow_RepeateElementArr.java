package com.example.java_practice.HuaweiOD;

//        题目描述:
//        如果一个数组中出现次数最多的元素出现大于等于k次，被称为-优雅数组，k也可以被称为 优雅闻值。
//        例如，数组[1,2,3,1,2,3,1]，它是一个3-优雅数组，因为元素1出现次数大于等于3次，数组[1,2,3,1,2]就不是一个3-优雅数组，因为其中出现次数最多的元素1和2，只出现了2次。
//        给定一个数组A和k，请求出A有多少子数组是~k-优雅子数组
//        子数组是数组中一个或多个连续元素组成的数组.
//
//        输入描述:
//        第一行输入两个整数n和k，n是数组A的长度，k是优雅闯值。第二行输入n个整数，表示给定的数组A。1 <= n <= 10000,1 <= k <= n数组A中的元素AD满足: 1 <= A[i] <= n
//        输出描述:
//        数据一个整数，表示数组A中k-优雅子数组~的数量行尾不要有多余空格

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SlidingWindow_RepeateElementArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input1 = sc.nextLine().split(" ");
        int n = Integer.valueOf(input1[0]);
        int k = Integer.valueOf(input1[1]);
        String[] input2 = sc.nextLine().split(" ");

        int[] num = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();
        int len = num.length;

        // 记录有效优雅数组个数
        int count = 0;

        // map存储已经滑动窗口内重复元素的个数
        Map<Integer, Integer> map = new HashMap<>();
        int index = -1; // 记录上一次r位置
        int l = 0;
        for (int r = 0; r < len; r++) {
            // 寻找满足条件的右指针
            map.put(num[r], map.getOrDefault(num[r], 0) + 1);
            if (map.get(num[r]) == k) {
                // 寻找满足条件的左指针
                while (l < r) {
                    if (num[l] == num[r]) {
                        break;
                    }
                    // 左指针l移动过程中删除窗口外记录
                    map.put(num[l], map.get(num[l]) - 1);
                    l++;
                }
                count += (num.length - r) * (l - index);
                // 记录左指针
                index = l;
                // 移除左指针元素
                map.put(num[r], map.get(num[r]) - 1);
                l++;
            }
        }

        System.out.println(count);
    }
}
