package com.example.java_practice.HuaweiOD;

//描述
//        以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数、左上角数和右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
//
//        求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3，输入2则输出-1。
//
//        数据范围：
//        1≤n≤10^9
//
//        输入描述：
//        输入一个int整数
//
//        输出描述：
//        输出返回的int值

import java.io.*;

public class YangHuiTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            int row = Integer.parseInt(str);
//            if (row < 3) {
//                System.out.println(-1);
//            } else if (row % 4 == 1 || row % 4 == 3) {
//                System.out.println(2);
//            } else if (row % 4 == 0) {
//                System.out.println(3);
//            } else {
//                System.out.println(4);
//            }
            int res = -1;
            switch ((row - 2) % 4) {
                case 1:
                    res = 2;
                    break;
                case 2:
                    res = 3;
                    break;
                case 3:
                    res = 2;
                    break;
                case 0:
                    res = 4;
                    break;
            }
            if (row <= 2) res = -1;
            System.out.println(res);
        }
    }
}
