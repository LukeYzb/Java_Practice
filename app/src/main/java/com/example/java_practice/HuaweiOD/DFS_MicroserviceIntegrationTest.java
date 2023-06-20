package com.example.java_practice.HuaweiOD;

//        题目描述:
//        现在有n个容器服务，服务的启动可能有一定的依赖性 (有些服务启动没有依赖)，:其次服务自身启动加载会消耗一些时间。
//        给你一个 n*n 的二维矩阵 useTime，其中 useTime[i][i]=10 表示服务i自身启动加载需要消耗10s，useTime[i][j]=1 表示服务 i 启动依赖服务 j 启动完成，
//        useTime[i][k]=0，表示服务 i 启动不依赖服务 k，其中 0 <= i，j，k < n。服务之间启动没有循环依赖(不会出现环)，若想对任意一个服务i进行集成测试(服务i自身也需要加载)，
//        求最少需要等待多少时间。
//        输入描述:
//        第一行输入服务总量 n，之后的 n 行表示服务启动的依赖关系以及自身启动加载耗时最后输入 k 表示计算需要等待多少时间后可以对服务 k 进行集成测试其中 1 <= k <=n， 1<=n<=100
//        输出描述:
//        最少需要等待多少时间(s)后可以对服务 k 进行集成测试。
//
//        示例1
//        输入:
//        3
//        500
//        150
//        015
//        3
//        输出:
//        15
//        说明:
//        服务3启动依赖服务2，服务2启动依赖服务1，由于服务1.2,3自身加载需要消耗5s，所以5+5+5=15，需等待15s后可以对服务3进行集成测试。

import java.util.*;

public class DFS_MicroserviceIntegrationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();

        int count = 0;
        count = dfs(nums, k - 1);
        System.out.println(count);
    }

    private static int dfs(int[][] nums, int k) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[k][i] != 0 && i != k) {
                max = Math.max(max, dfs(nums, i));
            }
        }

        return max + nums[k][k];
    }
}
