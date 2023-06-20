package com.example.java_practice.HuaweiOD;

//描述
//        N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
//
//        设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T1,T2,...,TK,
//        若存在i(1<i<K)使得T1<T2<...<Ti且Ti>Ti+1>...>TK，则称这K名同学排成了合唱队形。
//        通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
//        例子：
//        123 124 125 123 121 是一个合唱队形
//        123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
//        123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
//
//        你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
//
//        注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
//
//        数据范围：
//        1≤n≤3000
//
//        输入描述：
//        用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
//
//        输出描述：
//        最少需要几位同学出列

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chorus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while ((str = br.readLine()) != null) {
            if (str.equals("")) continue;
            int n = Integer.parseInt(str);
            int[] heights = new int[n];
            String[] str_heights = br.readLine().split(" ");

            // 当仅有一个人时，其自己组成一个合唱队，出列0人
            if (n <= 1) {
                System.out.println(0);
            } else {
                for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(str_heights[i]);

                // 记录从左向右的最长递增子序列和从右向左的最长递增子序列
                int[] seq = new int[n], rev_seq = new int[n];
                int[] k = new int[n];  // 用于记录以i为终点的从左向右和从右向走的子序列元素个数
                seq[0] = heights[0];  // 初始化从左向右子序列首元素为第一个元素
                int index = 1; // 记录当前子序列的长度

                for (int i = 1; i < n; i++) {
                    if (heights[i] > seq[index - 1]) {  // 当当前元素大于递增序列最后一个元素时
                        k[i] = index;  // 其左边元素个数
                        seq[index++] = heights[i];  // 更新递增序列
                    } else {  // 当当前元素位于目前维护递增序列之间时
                        // 使用二分搜索找到其所属位置
                        int l = 0, r = index - 1;
                        while (l < r) {
                            int mid = l + (r - l) / 2;
                            if (seq[mid] < heights[i]) l = mid + 1;
                            else r = mid;
                        }
                        seq[l] = heights[i];  // 将所属位置值进行替换
                        k[i] = l;  // 其左边元素个数
                    }
                }

                // 随后，再从右向左进行上述操作
                rev_seq[0] = heights[n - 1];
                index = 1;
                for (int i = n - 2; i >= 0; i--) {
                    if (heights[i] > rev_seq[index - 1]) {
                        k[i] += index;
                        rev_seq[index++] = heights[i];
                    } else {
                        int l = 0, r = index - 1;
                        while (l < r) {
                            int mid = l + (r - l) / 2;
                            if (rev_seq[mid] < heights[i]) l = mid + 1;
                            else r = mid;
                        }
                        rev_seq[l] = heights[i];
                        k[i] += l;
                    }
                }

                int max = 1;
                for (int num : k)
                    if (max < num) max = num;
                // max+1为最大的k
                System.out.println(n - max - 1);
            }
        }
    }
}
