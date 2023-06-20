package com.example.java_practice.HuaweiOD;

//        题目描述:
//        小明每周上班都会拿到自己的工作清单，工作清单内包含n项工作，每项工作都有对应的耗时时长 (单位h) 和报酬，工作的总报酬为所有已完成工作的报酬之和。那么请你帮小明安排一下工作，保证小明在指定的工作时间内工作收入最大化。
//        输入描述
//        输入的第一行为两个正整数T，n。T代表工作时长 (单位h,0<T< 100000) ，n代表工作数量(1< n 3000)接下来是n行，每行包含两个整数t，w。t代表该项工作消耗的时长(单位h，t> 0)，w代表该项工作的报酬。
//        输出描述:
//        输出小明指定工作时长内工作可获得的最大报酬。
//
//        示例1
//        输入:
//        40 3
//        20 10
//        20 20
//        20 5
//        输出:
//        30

import java.util.Scanner;

public class DynamicPlan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int n = sc.nextInt();

        int[] times = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int res = handle(T, times, values);

        System.out.println(res);

    }

    /**
     * 动态规划
     *
     * @param T      工作时长
     * @param times  任务工作数组
     * @param values 任务报酬数组
     * @return
     */
    public static int handle(int T, int[] times, int[] values) {

        int[] dp = new int[T + 1];    //相当于各个时间所能做的最大报酬

        for (int i = 0; i < times.length; i++) {
            for (int j = T; j >= times[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - times[i]] + values[i]);
            }
        }

        return dp[T];
    }
}
