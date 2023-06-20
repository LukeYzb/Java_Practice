package com.example.java_practice.HuaweiOD;

//描述
//        写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
//
//        数据范围：保证输入的数字在 32 位浮点数范围内
//        输入描述：
//        输入一个正浮点数值
//
//        输出描述：
//        输出该数值的近似整数值

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApproxNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        //get decimal part
        String[] split = str.split("\\.");
        sb.append(split[0]);

        //check the first digit of decimal, 0.5??=>1, 0.4??=>0
        if (split[1].toCharArray()[0] < '5') {
            res = Integer.parseInt(sb.toString());
        } else {
            res = Integer.parseInt(sb.toString()) + 1;
        }

        System.out.println(res);
    }
}
