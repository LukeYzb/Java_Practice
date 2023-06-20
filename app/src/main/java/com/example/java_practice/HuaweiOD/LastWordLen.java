package com.example.java_practice.HuaweiOD;

import java.io.IOException;
import java.io.InputStream;

//描述
//        计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
//        输入描述：
//        输入一行，代表要计算的字符串，非空，长度小于5000。
//
//        输出描述：
//        输出一个整数，表示输入字符串最后一个单词的长度。

public class LastWordLen {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        int len = 0;
        char c;

        //before the enter symbol '\n' it's this line's word
        while ((c = (char) inputStream.read()) != '\n') {
            //count the length of current word
            len++;
            //if this is not the last word, clear the length
            if (c == ' ') {
                len = 0;
            }
        }

        System.out.println(len);
    }
}
