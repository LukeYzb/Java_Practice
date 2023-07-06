package com.example.java_practice.HuaweiOD;

//        题目描述:
//        在系统、网络均正常的情况下组织核酸采样员和志愿者对人群进行核酸检测筛查。每名采样员的效率不同，采样效率为N人/小时。由于外界变化，采样员的效率会以M人/小时为粒度发生变化，M为采样效率浮动粒度，M=N*10%，输入保证N*10%的结果为整数。
//        采样员效率浮动规则:采样员需要一名志愿者协助组织才能发挥正常效率，在此基础上，每增加一名志愿者，效率提升1M，最多提升3M; 如果没有志愿者协助组织，效率下降2M。
//        怎么安排速度最快?求总最快检测效率 (总检查效率为各采样人员效率值相加)。
//        输入描述:
//        第一行: 第一个值，采样员人数，取值范围[1,100]; 第二个值，志愿者人数，取值范围[1,500];第二行: 各采样员基准效率值(单位人/小时)，取值范围[60,600]，保证序列中每项值计算10%为整数。
//        输出描述
//        第一行: 总最快检测效率(单位人/小时)。
//        补充说明:
//        输入需要保证采样员基准效率值序列的每个值*10%为整数。
//
//        示例1
//        输入:
//        2 3
//        200 200
//        输出:
//        440
//        解释:
//        第一位分配一名，第二位分配两名:200+(200*(1+(2*10%))=440，其余情况下不分配带来的损失太大。

import java.util.Scanner;

public class DP_NAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //采样员数量
        int N = sc.nextInt();
        //志愿者数量
        int V = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();     //采集员采样效率
        }

        int[] arrM = new int[N];
        for (int i = 0; i < N; i++) {
            arrM[i] = nums[i] / 10;       //采集员浮动效率
        }

        int[][] dp = new int[N + 1][V + 1];
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            count += (nums[i - 1] - 2 * arrM[i - 1]);
            dp[i][0] = count;   //没有志愿者的采集员采样效率
        }

        for (int i = 1; i < N + 1; i++) {     //采集员数量
            for (int j = 1; j < V + 1; j++) {     //志愿者数量
//                dp[i][j] = Math.max(dp[i][j], j - 1 >= 0 ? dp[i - 1][j - 1] + nums[i - 1] : 0);     //志愿者大于等于1
//                dp[i][j] = Math.max(dp[i][j], j - 2 >= 0 ? dp[i - 1][j - 2] + nums[i - 1] + arrM[i - 1] : 0);    //志愿者大于等于2
//                dp[i][j] = Math.max(dp[i][j], j - 3 >= 0 ? dp[i - 1][j - 3] + nums[i - 1] + 2 * arrM[i - 1] : 0);  //志愿者大于等于3
//                dp[i][j] = Math.max(dp[i][j], j - 4 >= 0 ? dp[i - 1][j - 4] + nums[i - 1] + 3 * arrM[i - 1] : 0);  //志愿者大于等于4（题目强调最多提示3M）
                if (j >= 1) {//志愿者大于等于1
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums[i - 1]);
                    if (j >= 2) {//志愿者大于等于2
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 2] + nums[i - 1] + arrM[i - 1]);
                        if (j >= 3) {//志愿者大于等于3
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 3] + nums[i - 1] + 2 * arrM[i - 1]);
                            if (j >= 4) {//志愿者大于等于4（题目强调最多提示3M）
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 4] + nums[i - 1] + 3 * arrM[i - 1]);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
