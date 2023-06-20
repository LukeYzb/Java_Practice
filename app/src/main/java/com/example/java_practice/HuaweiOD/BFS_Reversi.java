package com.example.java_practice.HuaweiOD;

//        题目描述
//        给定一个N行M列的二维矩阵，矩阵中每个位置的数字取值为0或1。矩阵示例如:
//        4 4
//        1 1 0 0
//        0 0 0 1
//        0 0 1 1
//        1 1 1 1
//        现需要将矩阵中所有的1进行反转为0，规则如下:
//        1)当点击一个1时，该1变被反转为0，同时相邻的上、下、左、右，以及左上、左下、右上、右下8个方向的1(如果存在1)均会自动反转为0;
//        2)进一步地，一个位置上的1被反转为0时，与其相邻的8个方向的1 (如果存在1) 均会自动反转为0
//        按照上述规则示例中的矩阵只最少需要点击2次后，所有值均为0。请问，给定一个矩阵，最少需要点击几次后，所有数字均为0?
//
//        输入描述:
//        第一行为两个整数，分别表示矩阵的行数N和列数M，取值范围均为[1,100]接下来N行表示矩阵的初始值，每行均为M个数，取值范围[0,1]
//        输出描述:
//        输出一个整数，表示最少需要点击的次数


import java.util.Scanner;

public class BFS_Reversi {

    public static int[][] juzhen;
    public static int N;
    public static int M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        juzhen = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                juzhen[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (juzhen[i][j] == 1) {
                    juzhen[i][j] = 0;
                    clearHappy(i, j);
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static void clearHappy(int x, int y) {

        if (x > 0) {
            if (juzhen[x - 1][y] == 1) {    //正上
                juzhen[x - 1][y] = 0;
                clearHappy(x - 1, y);
            }
            if (y > 0) {
                if (juzhen[x - 1][y - 1] == 1) {  //左上
                    juzhen[x - 1][y - 1] = 0;
                    clearHappy(x - 1, y - 1);
                }
            }
            if (y < M - 1) {
                if (juzhen[x - 1][y + 1] == 1) {    //右上
                    juzhen[x - 1][y + 1] = 0;
                    clearHappy(x - 1, y + 1);
                }
            }
        }

        if (x < N - 1) {
            if (juzhen[x + 1][y] == 1) {    //正下
                juzhen[x + 1][y] = 0;
                clearHappy(x + 1, y);
            }
            if (y > 0) {
                if (juzhen[x + 1][y - 1] == 1) {    //左下
                    juzhen[x + 1][y - 1] = 0;
                    clearHappy(x + 1, y - 1);
                }
            }
            if (y < M - 1) {
                if (juzhen[x + 1][y + 1] == 1) {  //右下
                    juzhen[x + 1][y + 1] = 0;
                    clearHappy(x + 1, y + 1);
                }
            }
        }

        if (y > 0) {
            if (juzhen[x][y - 1] == 1) {    //正左
                juzhen[x][y - 1] = 0;
                clearHappy(x, y - 1);
            }
        }

        if (y < M - 1) {
            if (juzhen[x][y + 1] == 1) {    //正右
                juzhen[x][y + 1] = 0;
                clearHappy(x, y + 1);
            }
        }
    }

}

class BFS_Reversi1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] numbers = new int[row][column];
        scanner.nextLine();
        for (int i = 0; i < row; i++) {
            String line = scanner.nextLine();
            String[] strs = line.split(" +");
            for (int j = 0; j < column; j++) {
                numbers[i][j] = Integer.parseInt(strs[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (numbers[i][j] == 1) {
                    turnZero(numbers, row, column, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void turnZero(int[][] numbers, int row, int col, int x, int y) {
        numbers[x][y] = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < row && j >= 0 && j < col &&
                        numbers[i][j] == 1) {
                    turnZero(numbers, row, col, i, j);
                }
            }
        }
    }
}
