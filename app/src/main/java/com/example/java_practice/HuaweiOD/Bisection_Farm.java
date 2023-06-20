package com.example.java_practice.HuaweiOD;

//        题目描述:
//        某农场主管理了一大片果园，fields[i] 表示不同果林的面积，单位:(m2)，现在要为所有的果林施肥且必须在 n 天之内完成，否则影响收成。
//        小布是果林的工作人员，他每次选择一片果林进行施肥，且一片果林施肥完后当天不再进行施肥作业。假设施肥机的能效为k，单位:(m^2/day)，
//        请问至少租赁能效为多少的施肥机才能确保不影响收成? 如果无法完成施肥任务，则返回 -1。
//        输入描述:
//        第一行输入为 m 和 n,m 表示 fields 中的元素个数，n 表示施肥任务必须在 n 天内(含n天) 完成第二行输入为 fields，fields[i] 表示果林i的面积，单位:(m^2)
//        输出描述:
//        对于每组数据，输出最小施肥机的能效 k，无多余空格
//        补充说明:
//        1 <= fields.length <= 10^4
//        1 <= n <= 10^9
//        1 <= fields[i] <= 10^9
//
//        示例1
//        输入:
//        5 7
//        5 7 9 15 10
//        输出:
//        9
//        说明:
//        当能效k为9时，fields[0] 需要1天, fields[1] 需要1天, fields[2] 需要天, fields[3] 需要2天， fields[4] 需要2天，共需要7天,不会响收成。
//
//        解题思路:
//        使用二分法。
//        获取最低能效l=1，获取最高能效 (面积最大的果林) r=max先取中间值mid = (l+r)/2，判断mid是否满足条件。
//        满足条件判断: ans为需要的天数。遍历林园面积除以mid，若能整除则ans t= 面积/mid，若不能整除，则ans = 面积/mid + 1; 若ans=m (规定天数)，则满足反之不满足。
//        若mid满足，则r=mid; 如不满足，则l=mid+1; 继续mid= (l+r) /2进行判断。以此类推，直至l>=r。

import java.util.Arrays;
import java.util.Scanner;

public class Bisection_Farm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] fields = new int[m];
        for (int i = 0; i < m; i++) {
            fields[i] = sc.nextInt();
        }

        int l = 1;  //最低能效
        int r = Arrays.stream(fields).max().getAsInt();     //最高能效
        while (l < r) {
            int mid = (l + r) / 2;      //取中位数
            if (check(mid, fields) <= n) {    //判断能效施肥满足天数要求
                r = mid;    //满足要求，右边界缩小
            } else {
                l = mid + 1;    //不满足，左边界缩小
            }
        }

        if (check(l, fields) > n) {
            System.out.println(-1);
        } else {
            System.out.println(l);
        }
    }

    /**
     * 判断mid能效需要几天完成施肥
     *
     * @param mid    能效
     * @param fields 面积数组
     * @return
     */
    public static int check(int mid, int[] fields) {
        int ans = 0;

        for (int i = 0; i < fields.length; i++) {
            if (fields[i] % mid == 0) {  //能整除能效则直接添加，否则需要+1
                ans += fields[i] / mid;
            } else {
                ans += fields[i] / mid + 1;
            }
        }

        return ans;
    }
}
