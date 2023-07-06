package com.example.java_practice.HuaweiOD;

//题目描述：
//短信充值优惠活动，给出客户预算，优惠售价序列，求可获得的最多短信条数。
//
//输入描述：
//第一行客户预算M，其中0<=M<=1000000
//第二行给出售价表，P1,P2...Pn，其中1<=n<=100，Pi为充值i元获得的短信条数，1<=Pi<=1000。
//
//示例1
//输入：
//6
//10 20 30 40 60
//输出：
//70
//分两次充值，1元、5元各一次，10+60=70。

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DP_BestChoiceInOffer {
    //recursion回溯
//    public static int max = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int M = sc.nextInt();
//        sc.nextLine();
//        String[] P = sc.nextLine().split(" ");
//
//        combine(P, M, new ArrayList<>(), 0);
//
//        System.out.println(max);
//    }
//
//    /**
//     * M中取N个数的算法
//     *
//     * @param strings 出售价表
//     * @param n       剩余的预算
//     * @param list    充值获得的短信条数的集合
//     * @param index   出售价表的索引
//     */
//    public static void combine(String[] strings, int n, List<Integer> list, int index) {
//
//        if (n == 0) {     //当预算等于0，退出循环
//            int count = 0;
//            for (int i = 0; i < list.size(); i++) {
//                count += list.get(i);
//            }
//            max = Math.max(max, count);
//        } else {
//            for (int i = index; i < strings.length; i++) {
//                int x = Integer.valueOf(strings[i]);
//                list.add(x);
//                combine(strings, n - (i + 1), list, i + 1);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    //dp动态规划DynamicPlan Knapsack背包算法
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] strs = in.nextLine().split(" ");
        int len = strs.length;
        int[] w = new int[len];
        int[] v = new int[len];

        for (int i = 0; i < len; i++) {
            w[i] = i + 1;
            v[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(dp(w, v, n));
    }

    public static int dp(int[] w, int[] v, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = n; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[n];
    }
}
