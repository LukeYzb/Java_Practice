package com.example.java_practice.HuaweiOD;

//        题目描述:
//        有5台打印机打印文件，每台打印机有自己的待打印队列。。因为打印的文件内容有轻重缓急之分，所以队列中的文件有1~10不同的优先级，其中数字越大优先级越高。打印机会从自己的待打印队列中选择优先级最高的文件来打印。如果存在两个优先级一样的文件，则选择最早进入队列的那个文件。
//        现在请你来模拟这5台打印机的打印过程
//
//        输入描述:
//        每个输入包含1个测试用例，每个测试用例第1行给出发生事件的数量 N( < N<1000)接下来有 N 行，分别表示发生的事件。
//        共有如下两种事件:
//        1."IN P NUM"，表示有一个拥有优先级· NUM 的文件放到了打印机 P 的待打印队列中。(0< P <= 5,0<NUM <= 10):
//        2."OUT P”，表示打印机 P 进行了一次文件打印，同时该文件从待打印队列中取出。(0 < P<= 5)
//        输出描述:
//        对于每个测试用例，每次"OUT P“事件，请在一行中输出文件的编号。如果此时没有文件可以打印，请输出"NULL"。文件的编号定义为:“IN P NUM”事件发生第 X 次，此处待打印文件的编号为 X。编号从1开始
//
//        示例1
//        输入:
//        IN 1 1
//        IN 1 2
//        IN 1 3
//        IN 2 1
//        OUT 1
//        OUT 2
//        OUT 2
//        输出:
//        2
//
//        解题思路:
//        使用map来放置打印任务
//        Key: 打印机的编号
//        Value: type: 集合 优先级和打印编号 (就是第几次打印)
//        碰到IN，将数据存入map
//        碰到OUT，则判断此打印机，且此打印机是否存在打印任务，存在则求出此打印机的打印任务集合，并将集合按照优先级进行升序排序，取出第一个元素，则为此次打印任务，并将此次任务移除，如不存在此打印机或者打印任务不存在，则输出NULL。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrintQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        /**
         * 将打印任务放在map对象中
         * key： String 打印机编号
         * value： List<int[]>数组集合
         *              int[0]： 优先级
         *              int[1]: 打印编号
         */
        Map<String, List<int[]>> map = new HashMap<>();
        int count = 0;  //打印编号
        for (int i = 0; i < n; i++) {
            String[] strs = sc.nextLine().split(" ");
            if (strs[0].equals("IN")) {   //打印任务
                int[] inInts = new int[2];
                inInts[0] = Integer.parseInt(strs[2]);  //优先级
                inInts[1] = ++count;   //打印编号递增
                List<int[]> inList = new ArrayList<>();
                if (map.containsKey(strs[1])) {
                    inList = map.get(strs[1]);
                    inList.add(inInts);
                } else {
                    inList.add(inInts);
                }
                map.put(strs[1], inList);
            } else if (strs[0].equals("OUT")) {    //进行打印
                if (!map.containsKey(strs[1])) {  //打印机不存在
                    System.out.println("NULL");
                    continue;
                }
                List<int[]> outList = map.get(strs[1]);     //获取strs[1]打印机的所有任务
                if (outList.size() == 0) {    //打印机没有任务
                    System.out.println("NULL");
                } else {
                    outList.sort((a, b) -> {     //根据打印优先级排序
                        return b[0] - a[0];
                    });
                    System.out.println(outList.get(0)[1]);
                    outList.remove(0);
                }
            }
        }
    }
}

class PrintQueue1 {
    public static void main(String[] args) {
        List<List<File>> m = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            m.add(new ArrayList<>());
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int flag = 0;
        for (int i = 0; i <= n; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            String type = s1[0];

            if ("IN".equals(type)) {
                int p = Integer.parseInt(s1[1]);
                int num = Integer.parseInt(s1[2]);
                flag++;
                File file = new File(flag, num);
                List<File> files = m.get(p - 1);
                files.add(file);
            } else if ("OUT".equals(type)) {
                int p = Integer.parseInt(s1[1]);
                List<File> files = m.get(p - 1);
                if (files != null && files.size() > 0) {
                    files.sort((a, b) -> {
                        return b.getWeight() - a.getWeight();
                    });
                    File file = files.get(0);
                    System.out.println(file.getIndex());
                    files.remove(0);
                } else {
                    System.out.println("NULL");
                }
            }

        }


    }
}

class File {
    private int index;
    private int weight;

    public File(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
