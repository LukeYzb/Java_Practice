package com.example.java_practice.HuaweiOD;

//        题目描述:
//        对称就是最大的美学，现有一道关于对称字符串的美学。已知:
//        第 1个字符串: R
//        第 2个字符串: BR
//        第 3 个字符串: RBBR
//        第 4 个字符串: BRRBRBBR
//        第 5 个字符串: RBBRBRRBBRRBRBBR
//        相信你已经发现规律了，没错!就是第  个字符串 = 第1 号字符串的取反 + 第1 号字符取反(R->B,B现在告诉你 n 和 k，让你求得第 n 个字符串的第 k 个字符是多少。(k的编号从 0 开始)
//        >R);
//
//        输入描述:
//        第一行输入一个T，表示有T组用例:接下里输入T行，每行输入两个数字，表示n,k
//        1 <= T <= 100:
//        1 <= n <= 64:
//        0 <= k < 2^(n-1);
//        输出描述:
//        输出T行表示答案:
//        输出“blue”表示字符是B:
//        输出“red”表示字符是R;
//        补充说明:
//        输出字符串区分大小写，请注意输出小写字符串，不带双引号
//
//        输入:
//        5
//        1 0
//        2 1
//        3 2
//        4 6
//        5 8
//        输出:
//        red
//        red
//        blue
//        blue
//        blue
//        说明:
//        第 1 个字符串: R > 第0个字符为R第 2 个字符串: BR -> 第1个字符为R
//        第 3 个字符串: RBBR -> 第2个字符为B
//        第 4 个字符串: BRRBRBBR > 第6个字符为B
//        第 5 个字符串: RBBRBRRBBRRBRBBR -> 第8个字符为B
//
//        解题思路:
//        算法1:
//        例:
//        58
//        n=5. k=8
//        第5个字符串: RBBRBRRBBRRBRBBR 总字符串个数 2^(5-1)= 16，半数half=16/2=8; k=8==half(8)，说明第k=8个字符在后半部分，这串字符是继承的第4个字符串，没有进行翻转，且此字符在第4个字符串的位置为8 - half(8)=0;
//        第 4 个字符串: BRRBRBBR 总字符串个数 2^(4-1)= 8，半数half=8/2=4;k=0<half(4)，说明第k=0个字符在前半部分，这串字符是经过第3个翻转的，则位置不变。
//        第 3 个字符串: RBBR 总字符串个数 2^(3-1)=4，半数half=4/2=2;k=0<half(2)，说明第k=0个字符在前半部分，这串字符是经过第2个翻转的，则位置不变。
//        第 2个字符串: BR 总字符串个数 2^(2-1)=2，半数half=2/2=1;k=0<half(1)，说明第k=0个字符在前半部分，这串字符是经过第1个翻转的，则位置不变。
//        第 1 个字符串: R 总字符串个数 2^(1-1)=1，到了第一个R.求出总共经过3次翻转，R->B->R->B，得到结果为blue。
//        算法2:
//        主要使用回溯求出所有字串，然后获取其对应索引的字符。

import java.io.BufferedInputStream;
import java.util.Scanner;

public class SymmetricFlipWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long charNum = (long) Math.pow(2, n - 1);       //第n行的总字符个数
            int re = doProcess(charNum, k, 0);
            if (re % 2 == 0) {
                System.out.println("red");      //翻转次数为2的倍数
            } else {
                System.out.println("blue");
            }
        }

    }

    /**
     * 翻转次数
     *
     * @param count   总字符的个数
     * @param cur     字符的索引
     * @param reverse 翻转次数
     * @return
     */
    public static int doProcess(long count, long cur, int reverse) {

        if (count == 1) {
            return reverse;
        }
        long half = count / 2;
        if (cur < half) {    //小于半数说明是经过翻转的部分
            reverse++;
            return doProcess(half, cur, reverse);
        } else {
            return doProcess(half, cur - half, reverse);
        }
    }

}

class SymmetricFlipWord1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        Solution solution = new Solution();
        int shuliang = sc.nextInt();
        for (int i = 0; i < shuliang; i++) {
            long a = sc.nextLong();
            double b = sc.nextDouble();
            if (solution.f(a, b) == 'R') {
                System.out.println("red");
            } else {
                System.out.println("blue");
            }
        }
    }

    public static class Solution {
        char f(long a, double b) {
            if (a == 1) {
                return 'R';
            }
            if (a == 2) {
                if (b == 0) return 'B';
                else return 'R';
            }
            double sz = pow(a);
            if (b < sz) {
                if (f(a - 1, b) == 'R') {
                    return 'B';
                } else {
                    return 'R';
                }

            }
            if (b >= sz) {
                double index = b - sz;
                return f(a - 1, index);
            }
            return 0;
        }

        double pow(long x) {
            return 1L << (x - 2);
        }
    }
}
