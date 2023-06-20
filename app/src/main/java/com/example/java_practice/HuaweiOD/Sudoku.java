package com.example.java_practice.HuaweiOD;

//描述
//        问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
//
//        输入描述：
//        包含已知数字的9X9盘面数组[空缺位以数字0表示]
//
//        输出描述：
//        完整的9X9盘面数组

import java.io.*;

public class Sudoku {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            char[][] arr = new char[9][];
            arr[0] = str.toCharArray();
            for (int i = 1; i < 9; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            dealnum(arr);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 9; i++) {
                sb.append(String.valueOf(arr[i]) + '\n');
            }
            System.out.println(sb.toString());
        }
    }

    private static boolean dealnum(char[][] arr) {
        int x = 0, y = 0;
        s:
        for (; x < 9; x++) {
            for (y = 0; y < 17; y += 2) {
                if (arr[x][y] == '0') {
                    break s;
                }
            }
        }
        if (x < 9 && y < 17) {
            boolean[] stu = new boolean[10];
            for (int i = 0; i < 9; i++) {
                stu[arr[x][i << 1] - '0'] = true;
                stu[arr[i][y] - '0'] = true;
            }
            int lx = (x / 3) * 3, ly = (y / 6) * 6;
            for (int i = lx; i < lx + 3; i++) {
                for (int j = ly; j < ly + 5; j += 2) {
                    stu[arr[i][j] - '0'] = true;
                }
            }
            for (int i = 1; i < 10; i++) {
                if (stu[i]) continue;
                arr[x][y] = (char) (i + '0');
                if (dealnum(arr)) return true;
                arr[x][y] = '0';
            }
            return false;
        }
        return true;
    }
}
