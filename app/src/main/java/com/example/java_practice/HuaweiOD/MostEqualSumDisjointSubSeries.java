package com.example.java_practice.HuaweiOD;

//        题目描述:
//        给定一个数组，我们称其中连续的元素为连续子序列，称这些元素的和为连续子席列的和。数组中可能存在几组连续子序列，组内的连续子序列互不相交且有相同的和。求一组连续子序列，组内子序列的数目最多。输出这个数目。
//        输入描述:
//        第一行输入为数组长度 N，1 <= N <= 103。
//        第二行为 N 个用空格分开的整数 Ci，-10^5 <= Ci <= 10^5.
//        输出描述:
//        是一个整数 M，表示满足要求的最多的组内子序列的数目。
//        单个的元素也算一个连续子序列！
//
//        示例1
//        输入:
//        10
//        8 8 9 1 9 6 3 9 10
//        输出:
//        4
//        说明:
//        四个子序列的第一个元素和最后一个元素的下标分别为:
//        2 2
//        4 4
//        5 6
//        7 7

//        解题思路:
//        例: nums = [-1,0,4,-3,6]新建一个n+1长度的数组，来记录各位置到0的连续子序列的和count = [0,0,0,0,0,0]
//        首先分别求每个位置到最初位置的连续元素的和，比如count = [0,-1,-1,0,0,0]代表count[1]=nums[0]，count[2]=nums[1]+nums[0]
//        求的过程中，可以倒推子序列的和，比如nums[1]=count[2]-count[1]
//        于是在每一次计算过程中，能根据以往的计算结果快速得出各个连续子序列的和

import java.util.*;

public class MostEqualSumDisjointSubSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        int[] ints = new int[N];

        for (int i = 0; i < N; i++) {
            ints[i] = Integer.valueOf(strings[i]);
        }

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int count = ints[i];
            for (int j = i; j < N; j++) {
                int[] temp = {i, j};   //首坐标i，尾座标j
                if (i != j) {    //单独的序列不需要进行求和
                    count += ints[j];
                }
                if (map.containsKey(count)) {
                    map.get(count).add(temp);
                } else {
                    List<int[]> tempList = new ArrayList<>();
                    tempList.add(temp);
                    map.put(count, tempList);
                }
            }
        }

        int res = 0;
        for (List<int[]> list : map.values()) {
            int count = removeIntersect(list);
            res = Math.max(res, count);
        }

        System.out.println(res);
    }

    /**
     * 求出子序列中互不相交的最长子序列
     *
     * @param list 和相同的子序列集合
     * @return 最长子序列的长度
     */
    public static int removeIntersect(List<int[]> list) {

        int count = 1;
        int size = list.size();

        int lastR = list.get(0)[1];
        for (int i = 1; i < size; i++) {
            if (lastR < list.get(i)[0]) {
                //区域不相交，更新右边界
                lastR = list.get(i)[1];
                count++;
            } else {
                //区域相交
                lastR = Math.min(lastR, list.get(i)[1]);
            }
        }
        return count;
    }

}
