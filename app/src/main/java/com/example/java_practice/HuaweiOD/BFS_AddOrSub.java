package com.example.java_practice.HuaweiOD;

//题目描述：只用数字a和数字b加或减，将数字s变成数字t。b可以使用无数次，求a的最少使用次数。题目保证数字s经过变化一定能变成数字t。

//输入：数字s，t，a，b, 1<=s,t,a,b<=105, a!=b。
//输出：一个整数，数字a的最少使用次数。

//解题思路：根据题意，加a和减a不会同时发生，用s和t的差值生成两个变量x和y，在while循环让x和y并分别加a或减a后整除b，最先能整除b时a的使用次数最少。

import java.util.Scanner;

public class BFS_AddOrSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int res = 0;
        int x = t - s, y = t - s;

        while (true) {
            if (x % b == 0 || y == 0) {
                break;
            }
            x += a;
            y -= a;
            res++;
        }

        System.out.println(res);
    }
}
