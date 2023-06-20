package com.example.java_practice.HuaweiOD;

//描述
//        矩阵乘法的运算量与矩阵乘法的顺序强相关。
//        例如：
//
//        A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
//
//        计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
//
//        编写程序计算不同的计算顺序需要进行的乘法次数。
//
//        进阶：时间复杂度：
//        O(n) ，
//        空间复杂度：
//        O(n)
//
//        输入描述：
//        输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
//        计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
//
//        输出描述：
//        输出需要进行的乘法次数

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MatrixMultiplicationOCBA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            int[][] arr = new int[num][2];

            for (int i = 0; i < num; i++) {
                String[] matrix = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(matrix[0]);
                arr[i][1] = Integer.parseInt(matrix[1]);
            }

            int n = arr.length - 1;
            char[] rule = br.readLine().toCharArray();
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for (int i = rule.length - 1; i >= 0; i--) {
                char one = rule[i];
                if (one == ')') {
                    stack.push(-1);
                } else if (one == '(') {
                    // 前一个矩阵
                    int n1 = stack.pop();
                    // 后一个矩阵
                    int n2 = stack.pop();
                    sum += arr[n1][0] * arr[n2][0] * arr[n2][1];
                    // 新矩阵
                    arr[n1][1] = arr[n2][1];
                    // 去掉一个右括号
                    stack.pop();
                    // 将新矩阵压入栈中
                    stack.push(n1);
                } else {
                    // 压入第n个矩阵
                    stack.push(n);
                    n--;
                }
            }
            System.out.println(sum);
        }
    }
}
