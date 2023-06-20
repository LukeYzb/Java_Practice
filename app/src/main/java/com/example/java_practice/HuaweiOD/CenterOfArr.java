package com.example.java_practice.HuaweiOD;

//        题目描述:
//        给你一个整数数组nums,请计算数组的中心位置。数组中心位置是数组的一个下标，其左侧所有元素相乘的积等于右侧所有元素相乘的积。
//        数组第一个元素的左侧积为1，最后一个元素的右侧积为1如果数组不存在中心位置，返回 -1。如果数组有多个中心位置，应该返回最靠近左边的那一个。
//
//        输入描述:
//        输入只有一行，给出N个正整数用空格分格: nums = 2 5 3 6 5 6
//        1 <= nums.length <= 1024
//        1 <= numsli] <= 10
//        输出描述:
//        输出: 3
//        解释:
//        中心位置是 3
//        左侧数之积 sum = nums[0] * nums[1]* nums[2] = 2* 5* 3 = 30，右侧数之积 sum = nums[4] * nums[5] = 5* 6 = 30，二者相等。

import java.util.Arrays;
import java.util.Scanner;

public class CenterOfArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int len = strings.length;
        int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        //题目说：数组第一个元素的左侧积为1，最后一个元素的右侧积为1
        int left = 1, right = 1;
        for (int num : nums) {
            right = right * num;    //数组的总乘积
        }

        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                left = left * nums[i - 1];    //左侧积做乘法
            }
            right = right / nums[i];    //右侧积做除法
            //输入是正整数，左边比右边大则之后也一样不可能相等
            if (left > right) {
                flag = false;
                break;
            }
            //如果左右成绩相等，输出左边的
            if (left == right) {
                System.out.print(i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }
}
