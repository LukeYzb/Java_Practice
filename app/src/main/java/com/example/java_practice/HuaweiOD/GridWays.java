package com.example.java_practice.HuaweiOD;

//描述
//        请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
//
//        注：沿棋盘格之间的边缘线行走
//
//        数据范围：
//        1≤n,m≤8
//
//
//        输入描述：
//        输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
//
//        输出描述：
//        输出一行结果

import java.io.*;

public class GridWays {
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bReader.readLine()) != null) {
            int n = Integer.valueOf(line.substring(0, line.indexOf(" ")));
            int m = Integer.valueOf(line.substring(line.indexOf(" ") + 1));
            System.out.println(getPath(n, m));
        }
    }

    public static int getPath(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    // 边上的每一个点的可能性都是1，因为走到边上，就只能顺着边往下走了，可能性只能是1
                    dp[i][j] = 1;
                } else {
                    // 往后每一个点，都是后面两个点的可能性之和，因为它可以选择任意一个点来走，可能性就是下两个点的可能性相加
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        // 最终加到最后一个点，可能性就是所有的路线数量
        return dp[n][m];
    }
}
