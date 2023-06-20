package com.example.java_practice.HuaweiOD;

//        题目描述:
//        小明有n块木板，第i (1 < =i< =n) 块木板的长度为ai.小明买了一块长度为m的木料，这块木料可以切割成任意块，拼接到已有的木板上，用来加长木板小明想让最短的木板尽量长。请问小明加长木板后，最短木板的长度最大可以为多少?
//
//        输入描述:
//        输入的第一行包含两个正整数，n(11n1103)，m(11m1106)-n表示木板数，m表示木料长度输入的第二行包含n个正整数，a1，a2，，，，，an (1 < =ai < =106).
//        输出描述
//        输出的唯一一行包含一个正整数，表示加长木板后，最短木板的长度最大可以为多少?
//
//        示例1
//        输入:
//        5 3
//        4 5 3 5 5
//        输出:
//        5
//        说明:
//        给第1块木板长度增加1，给第3块木板长度增加2后，这5块木板长度变为[5,5,5,5.5]，最短的木板的长度最大为5.
//        示例2
//        输入:
//        5 2
//        4 5 3 5 5
//        输出:
//        4
//        说明:
//        给第3块木板长度增加1后，这5块木板长度变为[4,5,4,5,5]，剩余木料的长度为1.
//        此时剩余木料无论给哪块木板加长，最短木料的长度都为4。

import java.util.Arrays;
import java.util.Scanner;

public class MakeShortestPlankLong {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        while (m > 0) {
            m--;    //木材一段一段的截
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    nums[i - 1]++;   //碰到比后面的短的就加一截
                    break;
                }
                if (i == n - 1) {
                    nums[i]++; //所有木材一样长则在最后一根加一截
                }
            }
        }

        System.out.println(nums[0]);
    }
}

class MakeShortestPlankLong1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数组长度
        int arrLen = sc.nextInt();
        //物料长度
        int len = sc.nextInt();

        int[] arr = new int[arrLen];
        int i = 0;
        while (sc.hasNext() && i < arrLen) {
            arr[i++] = sc.nextInt();
        }

        Arrays.sort(arr);
        //动态计算
        dynamicCal(arr, len);
        System.out.println(arr[0]);
        //System.out.println(ans);
    }

    public static void dynamicCal(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j + 1 < arr.length && arr[j] + 1 > arr[j + 1]) {
                    continue;
                }
                arr[j]++;
                break;
            }
        }
    }
}
