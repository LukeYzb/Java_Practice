package com.example.java_practice.HuaweiOD;

//描述
//        输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
//
//        数据范围：每个数组大小满足
//        1≤n≤50  ，输入的数据大小满足
//        ∣val∣≤500
//
//        输入描述：
//        第一行是数据个数，第二行是输入的数据
//
//        输出描述：
//        返回true或者false

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class ArrayGrouping {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = read.readLine()) != null) {
            int n = Integer.parseInt(input);
            int[] array = new int[n];
            String[] strs = read.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(solution(array));
        }
    }

    public static boolean solution(int[] array) {
        if (array.length < 2)
            return false;

        int sum = 0, sum3 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] % 5 == 0 && array[i] != 0)
                continue;
            else if (array[i] % 3 == 0 && array[i] != 0)
                sum3 += array[i];
            else
                list.add(array[i]);
        }
        if (sum % 2 != 0)
            return false;

        int num1 = sum / 2 - sum3;//第一个数组差的数

        return dfs(list, num1, 0);//在剩下的数字中找到和为num1的，如果没有返回false
    }

    private static boolean dfs(List<Integer> bag, int target, int i) {
        if (i == bag.size())
            return target == 0;//0==false
        // dfs搜索，对每个元素，选择或者放弃
        return dfs(bag, target, i + 1) || dfs(bag, target - bag.get(i), i + 1);
    }
}
