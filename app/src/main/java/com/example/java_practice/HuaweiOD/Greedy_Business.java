package com.example.java_practice.HuaweiOD;

//        题目描述:
//        商人经营一家店铺，有number种商品，由于仓库限制每件商品的最大持有数量是item[index]，每种商品的价格在每天是item_price[item_index][day]，
//        通过对商品的买进和卖出获取利润，请给出商人在davs天内能获取到的最大的利润。
//        注: 同一件商品可以反复买进和卖出:
//        输入描述:
//        3 // 输入商品的数量 number
//        3 // 输入商人售货天数 days
//        4 5 6 // 输入仓库限制每件商品的最大持有数量是item[index]
//        1 2 3 // 输入第一件商品每天的价格
//        4 3 2 // 输入第二件商品每天的价格
//        1 5 3 // 输入第三件商品每天的价格
//        输出描述:
//        32 // 输出商人在这段时间内的最大利润
//
//        解题思路:
//        通过双层for循环来求得最大利润;
//        第一层: 商品的循环，索引为number
//        第二层: 商品每天的价格，索引为day
//        题目说可以进行多次买卖，我们就今日买，隔天卖(大于进价时)。抓住每次利润，实现利润最大化。

import java.util.Scanner;

public class Greedy_Business {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int days = sc.nextInt();

        int[] item = new int[number];
        for (int i = 0; i < number; i++) {
            item[i] = sc.nextInt();
        }

        int[][] item_price = new int[number][days];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                item_price[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < number; i++) {
            for (int j = 1; j < days; j++) {
                int purchase = item_price[i][j - 1];    //进价
                int selling = item_price[i][j];     //卖价
                if (selling > purchase) {     //当卖价大于进价才有利润
                    res += (selling - purchase) * item[i];   //还需要乘以其数量
                }
            }
        }

        System.out.println(res);
    }
}
