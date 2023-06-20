package com.example.java_practice.HuaweiOD;

//描述
//        给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
//        此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
//        输入描述：
//        读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
//
//        输出描述：
//        对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false

import java.io.*;

public class TwentyFourPoints {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            String[] strNum = str.split(" ");
            int[] nums = new int[4];
            nums[0] = Integer.parseInt(strNum[0]);
            nums[1] = Integer.parseInt(strNum[1]);
            nums[2] = Integer.parseInt(strNum[2]);
            nums[3] = Integer.parseInt(strNum[3]);

            boolean flag24 = false;
            for (int i = 0; i < 4; i++) {
                if (is24dfs(nums, 1 << i, nums[i])) {
                    flag24 = true;
                    break;
                } else {
                    flag24 = false;
                }
            }

            System.out.println(flag24);
        }
    }

    // 判断是否24点
    public static boolean is24dfs(int[] nums, int used, int val) {
        if (val == 24) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int tmp = 1 << i; // 1左移i位 tmp 标识可否访问
            if ((tmp & used) == 0) { //位与
                tmp |= used;   // 位或 +赋值
                if (is24dfs(nums, tmp, val + nums[i]) ||
                        is24dfs(nums, tmp, val - nums[i]) ||
                        is24dfs(nums, tmp, val * nums[i]) ||
                        (nums[i] != 0 && val % nums[i] == 0 && is24dfs(nums, tmp, val / nums[i]))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean is24(int[] nums) {
        int[] nums1 = nums;

        boolean flag24 = false;
        for (int i = 0; i < 4; i++) {
            if (is24dfs(nums1, 1 << i, nums1[i])) {
                flag24 = true;
                break;
            } else {
                flag24 = false;
            }
        }

        return flag24;
    }
}
