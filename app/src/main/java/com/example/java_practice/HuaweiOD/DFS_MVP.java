package com.example.java_practice.HuaweiOD;

//        题目描述:
//        在星球争霸篮球赛对抗赛中，强大的宇宙战队，希望每个人都能拿到MVP。
//        MVP的条件是，单场最高分得分获得者，可以并列，所以宇宙战队决定在比赛中，尽可能让更多的队员上场，且让所有有得分的队员得分都相同。
//        然而比赛过程中的每一分钟的得分都只能由某一个人包揽
//        输入描述:
//        输入第一行为一个数字t，表示有得分的分钟数 (1 <=  = 50)，第二行为个数字，代表每一分钟的得分p (1 <= p = 50)
//        输出描述:
//        输出有得分的队员都是MVP时最少的MVP得分。
//
//        示例1
//        输入:
//        5 2 1 5 2 1 5 2 1
//        输出:
//        6
//        说明:
//        样例解释: 一共4人得分，分别都为6分
//        5+1
//        5+1
//        5+1
//        2+2+2
//
//        解题思路:
//        首先对得分数组进行排序，确定平均得分的最小值和最大值。
//        最小值: 得分数组的最大值 (因为每一分钟的得分都只能由某一个人包揽)
//        最大值: 得分总数/2 (最低两个人平分)
//        从最小值遍历到最大值，需要注意的是，只有总得分整除平均分时才有必要去判断。判断的时候需要从最大值开始遍历(也就是得分数组尾部)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DFS_MVP {
    public static int score = 0;    //MVP得分

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] p = sc.nextLine().split(" ");
        int[] ints = new int[t];

        for (int i = 0; i < p.length; i++) {
            ints[i] = Integer.valueOf(p[i]);
        }

        int count = Arrays.stream(ints).sum();
        Arrays.sort(ints);      //对数组进行排序，
        int min = ints[t - 1];    //求出数组中最大值，为MVP最低得分

        int res = 0;
        for (int i = min; i <= count / 2; i++) {     //以2个人平分的分数为边界
            if (count % i == 0) {   //得分总数可以整除得分
                score = i;      //当前平均分
                if (combine(ints, score, new ArrayList<>(), t - 1)) {   //从最后一位开始计算（否则会出现问题）
                    res = score;
                    break;
                }
            }
        }

        System.out.println(res == 0 ? count : res);     //分数平分不成功则输出总分
    }

    /**
     * @param ints  篮球得分数组
     * @param n     分数
     * @param list  使用过的得分
     * @param index 得分数组的索引
     * @return
     */
    public static boolean combine(int[] ints, int n, List<Integer> list, int index) {
        if (n <= 0) {   //分配的得分小于等于平均分
            if (n == 0) {
                for (int i = 0; i < list.size(); i++) {   //将分配过的得分清0（此处不能用删除，否则会越界）
                    ints[list.get(i)] = 0;
                }
                return true;
            }
        }
        for (int i = index; i >= 0; i--) {
            if (n < 0 || Arrays.stream(ints).sum() == 0) {        //得分小于0或者总得分等于0时跳出循环
                break;
            }
            int x = ints[i];
            if (x == 0) {     //此得分失效时寻找下一个得分
                continue;
            }
            list.add(i);    //分配过的得分集合
            if (combine(ints, n - x, list, i - 1)) {      //分数获取成功后继续下一个分数分配
                int count = Arrays.stream(ints).sum();  //当前得分数组中所剩的总得分
                if (count == 0 || count % score != 0) {     //剩余总分等于0或不能对得分进行整除则跳出循环
                    break;
                }
                combine(ints, score, new ArrayList<>(), ints.length - 1);
            }
            list.remove(list.size() - 1);
        }

        return Arrays.stream(ints).sum() == 0;      //如果剩余总分等于0则表示分配成功
    }
}
