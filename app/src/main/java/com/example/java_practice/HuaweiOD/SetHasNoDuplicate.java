package com.example.java_practice.HuaweiOD;

//        题目描述:
//        任务编排服务负责对任务进行组合调度。参与编排的任务有两种类型，其中一种执行时长为taskA，另一种执行时长为taskB。任务一旦开始执行不能被打断，且任务可连续执行。服务每次可以编排num个任务。请编写一个方法，生成每次编排后的任务所有可能的总执行时长。
//        输入描述
//        第1行输入分别为第1种任务执行时长taskA，第2种任务执行时长taskB，这次要编排的任务个数num，以逗号分隔.
//        输出描述:
//        数组形式返回所有总执行时时长，需要按从小到大排列
//        补充说明:
//        每种任务的数量都大于本次可以编排的任务数量。
//        0 < taskA
//        0 < taskB
//        0 <= num <= 100000
//
//        示例1
//        输入:
//        1,2,3
//        输出:
//        [3, 4, 5, 6]
//        说明:
//        可以执行 3 次 taskA，得到结果 3; 执行 2次 taskA和 1次 taskB，得到结果 4。以此类推，得到最终结果。

import java.util.*;

public class SetHasNoDuplicate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(",");
        int taskA = Integer.valueOf(input[0]);
        int taskB = Integer.valueOf(input[1]);
        int nums = Integer.valueOf(input[2]);
        //set has no duplicate
        HashSet<Integer> set = new HashSet<>();
        if (nums != 0) {
            int countA = nums;
            while (countA >= 0) {
                int countB = nums - countA;
                set.add(countA * taskA + countB * taskB);
                countA--;
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        System.out.println(ans);
    }

}
