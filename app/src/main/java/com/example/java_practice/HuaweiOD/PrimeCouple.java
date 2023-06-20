package com.example.java_practice.HuaweiOD;

//描述
//        题目描述
//        若两个正整数的和为素数(也称质数，指从1开始的自然数内，只能被1和自身整除的数)，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
//
//        输入:
//        有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
//
//        输出:
//        输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
//
//
//        数据范围：
//        1≤n≤100  ，输入的数据大小满足
//        2≤val≤30000
//        输入描述：
//        输入说明
//        1 输入一个正偶数 n
//        2 输入 n 个整数
//
//        输出描述：
//        求得的“最佳方案”组成“素数伴侣”的对数。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeCouple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while ((line = br.readLine()) != null) {
            int count = Integer.parseInt(line);
            String[] elements = br.readLine().split(" ");
            int[] nums = new int[count];
            int oddCount = 0;
            int index = 0;
            for (String ele : elements) {
                nums[index] = Integer.parseInt(ele);
                if (nums[index] % 2 == 1) {
                    oddCount++;    //记录奇数个数
                }
                index++;
            }

            int[] oddNums = new int[oddCount];
            int[] evenNums = new int[count - oddCount];
            int oddIndex = 0;
            int evenIndex = 0;
            //奇偶分离
            for (int num : nums) {
                if (num % 2 == 0) {
                    evenNums[evenIndex++] = num;
                } else {
                    oddNums[oddIndex++] = num;
                }
            }

            int pairCount = 0;
            int[] evenPair = new int[evenIndex];
            for (int i = 0; i < oddIndex; i++) {
                boolean[] used = new boolean[evenIndex];
                if (findPair(i, oddNums, evenNums, evenPair, used)) {
                    pairCount++;
                }
            }
            System.out.println(pairCount);
        }
    }

    /**
     * 偶数+奇数才可能是素数
     */
    private static boolean findPair(int oddIndex, int[] oddNums, int[] evenNums, int[] evenPair, boolean[] used) {
        for (int i = 0; i < evenNums.length; i++) {
            if (!used[i] && isP(oddNums[oddIndex] + evenNums[i])) {
                used[i] = true;
                if (evenPair[i] == 0 || findPair(evenPair[i] - 1, oddNums, evenNums, evenPair, used)) {
                    evenPair[i] = oddIndex + 1;
                    return true;
                }
            }
        }
        return false;
    }

    //见过比较经典的思路
    private static boolean isP(int num) {
        if (num <= 3) {
            return num > 1;    // 2,3都是素数
        }
        //6*n+2;6*n+3;6*n+4;6*n等都不是素数;可过滤掉2/3的判断
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }

        double sqrt = Math.sqrt(num);
        for (int i = 5; i < sqrt; i += 6) {
            //只变量2类数据num % 6 == 1 num % 6 == 5
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
