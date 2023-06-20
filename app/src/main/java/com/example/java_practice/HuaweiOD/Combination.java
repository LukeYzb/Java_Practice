package com.example.java_practice.HuaweiOD;

//把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。

//输入
//每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。

//样例输入
//7 3

//样例输出
//8

/**
 * 计算放苹果方法数目
 * <p>
 * 输入值非法时返回-1
 * 0<=m<=10，1<=n<=10
 *
 * @param m 苹果数目
 * @param n 盘子数目数
 * @return 放置方法总数
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Combination {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            //num of apples
            int m = Integer.parseInt(s[0]);
            //num of plates
            int n = Integer.parseInt(s[1]);

            System.out.println(count(m, n));
        }
    }

    public static int count(int m, int n) {
        if (n == 1 || m == 0) return 1;
            //if more plates than apples, the largest num of plates needed are same to the num of apples
        else if (n > m) return count(m, m);
            //has empty plate(s) or not
        else return count(m, n - 1) + count(m - n, n);
    }

    public int count1(int m, int n) {
        if (n == 1 || m == 0) return 1;
            //if more plates than apples, the largest num of plates needed are same to the num of apples
        else if (n > m) return count(m, m);
            //has empty plate(s) or not
        else return count(m, n - 1) + count(m - n, n);
    }
}
