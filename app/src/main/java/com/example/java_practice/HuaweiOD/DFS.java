package com.example.java_practice.HuaweiOD;

//        题目描述:
//        给定一个 m x n 的矩阵，由若于字符X 和O构成，"X表示该处已被占据，0"表示该处空闲，请找到最大的单入空闲区域。
//        解释:
//        空闲区域是由连通的"O组成的区域，位于边界的'O'可以构成入口，单入口空闲区域即有目只有一个位于边界的'o'作为入口的由连通的O'组成的区域。
//        如果两个元素在水平或垂直方向相邻，则称它们是“连通”的。
//
//        输入描述:
//        第一行输入为两个数字，第一个数字为行数m，第二个数字列数n，两个数字以空格分隔，1 <= m,n <= 200.剩余各行为矩阵各行元素，元素为'X’或o，各元素间以空格分隔
//        输出描述:
//        若有唯一符合要求的最大单入口空闲区域，输出三个数字，第一个数字为入口行坐标(范围为0~行数-1)，第二个数字为入口列坐标(范围为0~列数-1) ，第三个数字为区域大小，三个数字以空格分隔;
//        若有多个符合要求的最大单入口空闲区域，输出一个数字，代表区域的大小:
//        若没有，输出NULL。
//
//        示例1
//        输入:
//        4 4
//        xxxx
//        xoox
//        xoox
//        xoxx
//        输出:
//        3 1 5
//        说明:
//        存在最大单入口区域，入口行坐标3，列坐标1，区域大小5
//
//        解题思路:
//        通过回湖法求出所有满足的区域在回溯的同时记录其入口坐标
//        入口个数大于1则不符合要求
//        入口个数等于1时，判断其区域大小; 如果存在多个区域，且区域大小相同，则只需记录其大小;其他情况则需要记录区域最大值和横纵坐标

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DFS {

    public static int m;
    public static int n;
    public static String[][] strings;
    public static int[] rukou = new int[2]; //入口坐标
    public static int count = 0;    //入口个数


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        strings = new String[m][n];
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String[] strInput = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                strings[i][j] = strInput[j];
            }
        }

        int max = 0;    //最大的区域大小
        List<int[]> quyu = new ArrayList<>();   //最大区域的入口坐标和其区域大小的集合
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (strings[i][j].equals("O")) {
                    strings[i][j] = "X";    //已经统计过的区域置为"X"
                    List<int[]> zuobiao = new ArrayList<>();    //区域中的坐标集合
                    zuobiao.add(new int[]{i, j});
                    qiuquyu(i, j, zuobiao);
                    if (count == 1) {  //只有一个入口的区域
                        if (max == zuobiao.size()) {  //有大小相同的单入口空闲区域，只需要大小，无需坐标
                            quyu.clear();
                        } else if (max < zuobiao.size()) {
                            quyu.clear();
                            quyu.add(new int[]{rukou[0], rukou[1], zuobiao.size()});
                            max = zuobiao.size();
                        }
                    }
                    count = 0;  //重置入口数量
                    rukou = new int[2];  //重置入口坐标
                }
            }
        }

        if (quyu.size() == 1) {
            int[] res = quyu.get(0);
            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        } else if (max != 0) {
            System.out.println(max);
        } else {
            System.out.println("NULL");
        }

    }

    /**
     * @param x    横坐标
     * @param y    纵坐标
     * @param list 区域内的坐标集合
     */
    public static void qiuquyu(int x, int y, List<int[]> list) {
        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {   //边界为入口坐标
            count++;  //入口的数量计数
            rukou[0] = x;
            rukou[1] = y;
        }

        if (x < m - 1) {
            if (strings[x + 1][y].equals("O")) {
                strings[x + 1][y] = "X";  //已经统计过的区域需要置为"X"，避免统计重复
                list.add(new int[]{x + 1, y});
                qiuquyu(x + 1, y, list);
            }
        }
        if (x > 0) {
            if (strings[x - 1][y].equals("O")) {
                strings[x - 1][y] = "X";  //已经统计过的区域需要置为"X"，避免统计重复
                list.add(new int[]{x - 1, y});
                qiuquyu(x - 1, y, list);
            }
        }
        if (y < n - 1) {
            if (strings[x][y + 1].equals("O")) {
                strings[x][y + 1] = "X";  //已经统计过的区域需要置为"X"，避免统计重复
                list.add(new int[]{x, y + 1});
                qiuquyu(x, y + 1, list);
            }
        }
        if (y > 0) {
            if (strings[x][y - 1].equals("O")) {
                strings[x][y - 1] = "X";  //已经统计过的区域需要置为"X"，避免统计重复
                list.add(new int[]{x, y - 1});
                qiuquyu(x, y - 1, list);
            }
        }
    }

}

class DFS1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int m = in.nextInt();
            int n = in.nextInt();
            in.nextLine();
            Character[][] ca = new Character[m][n];
            for (int i = 0; i < m; i++) {
                String[] sa = in.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    ca[i][j] = sa[j].charAt(0);
                }
            }

            int maxCount = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (ca[0][j] == 'O') {
                    int count = calc(copy(ca), 0, j, true);
                    if (count > 0) {
                        String key = 0 + " " + j;
                        map.put(key, count);
                        if (count > maxCount) {
                            maxCount = count;
                        }
                    }
                }

                if (ca[m - 1][j] == 'O') {
                    int count2 = calc(copy(ca), m - 1, j, true);
                    if (count2 > 0) {
                        String key = (m - 1) + " " + j;
                        map.put(key, count2);
                        if (count2 > maxCount) {
                            maxCount = count2;
                        }
                    }
                }
            }

            for (int i = 1; i < m - 1; i++) {
                if (ca[i][0] == 'O') {
                    int count = calc(copy(ca), i, 0, true);
                    if (count > 0) {
                        String key = i + " " + 0;
                        map.put(key, count);
                        if (count > maxCount) {
                            maxCount = count;
                        }
                    }
                }

                if (ca[i][n - 1] == 'O') {
                    int count2 = calc(copy(ca), i, n - 1, true);
                    if (count2 > 0) {
                        String key = i + " " + (n - 1);
                        map.put(key, count2);
                        if (count2 > maxCount) {
                            maxCount = count2;
                        }
                    }
                }
            }

            String maxKey = "";
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == maxCount) {
                    if (maxKey.isEmpty()) {
                        maxKey = e.getKey();
                    } else {
                        maxKey = "more";
                        break;
                    }
                }
            }

            if (maxCount == 0) {
                System.out.println("NULL");
            } else if (maxKey == "more") {
                System.out.println(maxCount);
            } else {
                System.out.println(maxKey + " " + maxCount);
            }
        }
    }

    public static Character[][] copy(Character[][] a) {
        int m = a.length;
        int n = a[0].length;
        Character[][] ca = new Character[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ca[i][j] = a[i][j];
            }
        }
        return ca;
    }

    public static int calc(Character[][] ca, int i, int j, boolean isRuKou) {
        if (!isRuKou) {
            if (i == 0 || i == ca.length - 1 || j == 0 || j == ca[0].length - 1) {
                return 0;
            }
        }

        ca[i][j] = 'X';
        int count = 1;

        if (j + 1 < ca[0].length && ca[i][j + 1] == 'O') {
            int count1 = calc(ca, i, j + 1, false);
            if (count1 == 0) {
                return 0;
            }
            count += count1;
        }

        if (i + 1 < ca.length && ca[i + 1][j] == 'O') {
            int count1 = calc(ca, i + 1, j, false);
            if (count1 == 0) {
                return 0;
            }
            count += count1;
        }

        if (j - 1 >= 0 && ca[i][j - 1] == 'O') {
            int count1 = calc(ca, i, j - 1, false);
            if (count1 == 0) {
                return 0;
            }
            count += count1;
        }

        if (i - 1 >= 0 && ca[i - 1][j] == 'O') {
            int count1 = calc(ca, i - 1, j, false);
            if (count1 == 0) {
                return 0;
            }
            count += count1;
        }

        return count;
    }
}
