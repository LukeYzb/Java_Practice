package com.example.java_practice.HuaweiOD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//描述
//        明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
//
//        数据范围：1≤n≤1000  ，输入的数字大小满足 1≤val≤500
//
//        输入描述：
//        第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
//        输出描述：
//        输出多行，表示输入数据处理后的结果

public class RandomNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            //num of input: 1<=n<=1000, thus len of array should be 1001
            boolean[] stu = new boolean[1001];
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(str);

            for (int i = 0; i < n; i++) {
                stu[Integer.parseInt(br.readLine())] = true;
            }
            for (int i = 0; i < 1001; i++) {
                if (stu[i]) {
                    sb.append(i).append("\n");
                }
            }
            sb.deleteCharAt(sb.length() - 1);

            System.out.println(sb.toString());
        }
    }
}
