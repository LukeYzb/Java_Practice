package com.example.java_practice.HuaweiOD;

//描述
//        计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
//
//        3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
//
//        本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
//
//        详细说明：
//
//        1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，没有括号，友情提醒，整数除法要当心，是属于整除，比如2/3=0，3/2=1；
//        2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
//        3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
//        4.输出的算式格式为4张牌通过+-*/四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
//        5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24，2 A 9 A不能变为(2+1)*(9-1)=24
//        6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
//        7.因为都是扑克牌，不存在单个牌为0的情况，且没有括号运算，除数(即分母)的数字不可能为0
//
//        数据范围：一行由4张牌组成的字符串
//        输入描述：
//        输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
//
//        输出描述：
//        输出怎么运算得到24，如果无法得出24，则输出“NONE”表示无解，如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；

import java.io.*;

public class PokerTwentyFourPoints {
    public static void main(String[] args) throws IOException {
        fx();
    }

    //region    89  24点运算
    private static String[] op = new String[]{"+", "-", "*", "/"};

    private static void fx() throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = re.readLine()) != null && !"".equals(input)) {
            String[] ss = input.split(" ");
            int a = getInputNum(ss[0]);
            int b = getInputNum(ss[1]);
            int c = getInputNum(ss[2]);
            int d = getInputNum(ss[3]);
            // 只要有joker，直接返回ERROR
            if (a == -1 || b == -1 || c == -1 || d == -1) {
                System.out.println("ERROR");
                continue;
            }
            compute(a, b, c, d);
        }
        re.close();
    }

    /**
     * 24点计算方法穷举
     *
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public static void compute(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        // 运算符穷举数组
        String[][] arr1 = symbol();
        for (int i = 0; i < 4; i++) {// 第一个数字
            for (int j = 0; j < 4; j++) {// 第二个数字
                for (int k = 0; k < 4; k++) {// 第三个数字
                    for (int p = 0; p < 4; p++) {// 第四个数字
                        if ((i != j) && (i != k) && (i != p) && (j != k) && (j != p) && (k != p)) {// 如果四个数字互不相等才计算，不然一个字符就会出现两次
                            // 遍历运算符穷举数组
                            for (String[] str : arr1) {
                                // 依次计算，得出最终结论
                                int sum = sumNum(arr[i], arr[j], str[0]);
                                sum = sumNum(sum, arr[k], str[1]);
                                sum = sumNum(sum, arr[p], str[2]);
                                if (sum == 24) {
                                    // 如果结果等于24，返回结果
                                    String str1 = change2(arr[i]) + str[0] + change2(arr[j]) + str[1] + change2(arr[k]) + str[2] + change2(arr[p]) + "";
                                    System.out.println(str1);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        // 穷举之后仍然没有结果，返回none
        System.out.println("NONE");
    }

    /**
     * 穷举所有可能的运算符组合
     *
     * @return
     */
    public static String[][] symbol() {
        //运算符共三个，每个四种可能性，4*4*4中运算符组合，每个组合有三个运算符
        String[][] symbol = new String[64][3];
        int p = 0;
        for (int i = 0; i < 4; i++) {// 第一个运算符
            for (int j = 0; j < 4; j++) {// 第二个运算符
                for (int k = 0; k < 4; k++) {// 第三个运算符
                    symbol[p++] = new String[]{op[i], op[j], op[k]};
                }
            }
        }
        return symbol;
    }


    /**
     * 两个数字计算结果
     *
     * @param a
     * @param b
     * @param symb
     * @return
     */
    public static int sumNum(int a, int b, String symb) {
        switch (symb) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }


    /**
     * 字符串转数字
     *
     * @param str
     * @return
     */
    public static int getInputNum(String str) {
        switch (str.toUpperCase()) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "JOKER":
                return -1;
            default:
                return Integer.parseInt(str);
        }
    }

    /**
     * 数字转化为字符串
     *
     * @param i
     * @return
     */
    public static String change2(int i) {
        switch (i) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(i);
        }
    }
}
