package com.example.java_practice.HuaweiOD;

//        题目描述:
//        输入单行英文句子，里面包含英文字母，空格以及,.? 三种标点符号，请将句子内每个单词进行倒序，并输出倒序后的语句
//        输入描述:
//        输入字符串S，S的长度1≤N≤100
//        输出描述:
//        输出逆序后的字符串
//        补充说明:
//        标点符号左右的空格20，单词间空格 >0
//
//        示例1
//        输入:
//        yM eman si boB
//        输出:
//        My name is Bob
//        示例2
//        输入:
//        woh era uoy ? I ma enif.
//        输出:
//        how are you ? l am fine.
//
//        解题思路:
//        1. 通过字符串分割将输入值转化为字符串数组
//        2.遍历步骤1中的数组，将其所有单词进行反转后拼接，碰到标点直接拼接字符串反转的算法还是比较多的，我使用的是倒序输出。就是从尾部开始遍历到头部，依次输出字符。

import java.util.Scanner;

public class WordReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        String res = "";
        String temp = "";   //用来拼接字符的临时容器
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetter(c)) {      //判断是否是字母
                temp += c;
            } else if (c == ' ') {
                res += reverse(temp) + " ";     //遇到空格，对temp进行反转，需要加上空格
                temp = "";  //需要对temp置空
            } else {
                if (temp != "") {
                    res += reverse(temp);   //如果temp不为空则需要反转后拼接
                    temp = "";      //对temp进行置空
                }
                res += c;       //标点符号直接进行拼接
            }
            if (i == string.length() - 1 && temp != "") {
                res += reverse(temp);   //如果最后一个字符是字母
            }
        }

        System.out.println(res);
    }

    /**
     * 反转字符串中的字符
     *
     * @param str
     * @return
     */
    public static String reverse(String str) {

        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }

        return res;

    }

}

class WordReverse1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String result = "";
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == ' ' || a == '?' || a == '.' || a == ',') {
                if (i > start) {
                    StringBuilder word = new StringBuilder(str.substring(start, i));
                    result = result + word.reverse() + a;
                } else {
                    result = result + a;
                }
                start = i + 1;
            } else if (i == str.length() - 1) {
                StringBuilder word = new StringBuilder(str.substring(start, i + 1));
                result = result + word.reverse();
            }
        }
        System.out.println(result);
    }
}
