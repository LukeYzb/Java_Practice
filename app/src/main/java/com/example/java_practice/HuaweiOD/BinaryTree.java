package com.example.java_practice.HuaweiOD;

//        题目描述:
//        小明在学习二进制时，发现了一类不含101的数，也就是:
//        将数字用二进制表示，不能出现101。
//        现在给定一个正整数区间[l,r]，请问这个区间内包含了多少个不含101的数?
//        输入描述:
//        输入的唯一一行包含两个正整数l,r(1<=l<r<=109)。
//        输出描述:
//        输出的唯一一行包含一个整数，表示在[l,r]区间内一共有几个不含101的数。
//
//        解题思路:
//        对于满二叉树而言
//        dp[n] = dp[n-1] + dp[n-3] + dp[n-1] + dp[n-2] (n>2)
//        dp[0] = 1
//        dp[1] = 2
//        dp[4] = 4
//        非满二叉树看代码

import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        //因为右边界也包含在内，所以右侧需要-1
        int res = handle(r) - handle(l - 1);

        System.out.println(res);
    }

    public static int handle(int num) {

        //10^9=1,000,000,000；2^30=1,073,741,824；数组长度设定为30
        int[] dp = new int[31];

        dp[0] = 1;  //0
        dp[1] = 2;  //0,1
        dp[2] = 4;  //00,01,10,11
        for (int i = 3; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 1] - dp[i - 2];
        }

        // preOfPre 记录上上一层的根节点值
        // pre 记录上一层的根节点值
        // res 记录最终路径数
        int preOfPre = 0, pre = 0, count = 0;
        for (int i = 29; i >= 0; i--) {
            //位运算，用来判断是否包含右子树
            int val = 1 << i;
            //判断当前子树是否有右子树
            if ((num & val) != 0) {
                // 有右子树
                num -= val;
                if (pre == 1) {
                    //上节点为1则说明左子树（满二叉树）的右子树不符合要求
                    //只能将左子树的左子树dp[i-1]（满二叉树）加到结果中
                    count += i == 0 ? 1 : dp[i - 1];
                } else {
                    count += dp[i]; // 先将左子树dp[i]（满二叉树）加到结果中
                }

                //出现了“101”的情况说明下面都可以忽略了
                if (preOfPre == 1 && pre == 0) {
                    break;
                }
                //更新上上节点值，标记当前根节点为 1
                preOfPre = pre;
                pre = 1;
            } else {
                // 无右子树，此时不能保证左子树是否为满二叉树，所以要在下一层再继续判断
                //更新上上节点值，标记当前根节点为 0
                preOfPre = pre;
                pre = 0;
            }

            //不能忘记最后一层的最后一个数
            if (i == 0) {
                count += 1;
            }
        }

        return count;
    }
}
