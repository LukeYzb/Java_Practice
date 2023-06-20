package com.example.java_practice.HuaweiOD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//描述
//        写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
//
//        数据范围：1≤n≤1000
//
//        输入描述：
//        第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
//
//        输出描述：
//        输出输入字符串中含有该字符的个数。（不区分大小写字母）

public class ThisWordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //regardless of case
        char[] chars1 = br.readLine().toLowerCase().toCharArray();
        char[] chars2 = br.readLine().toLowerCase().toCharArray();
        int count = 0;

        for (int i = 0; i < chars1.length; i++) {
            //check if it's a word, then count word  frequency
            if ((chars1[i] >= 65 || chars1[i] < 90) && (chars1[i] == chars2[0])) {
                count++;
            }
        }

        System.out.println(count);
    }
}
