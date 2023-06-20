package com.example.java_practice.HuaweiOD;

//描述
//        给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
//        要求输出所有火车出站的方案，以字典序排序输出。
//        火车按顺序行动。
//        数据范围：
//        1≤n≤10
//
//        进阶：时间复杂度：
//        O(n!) ，
//        空间复杂度：
//        O(n)
//
//        输入描述：
//        第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
//
//        输出描述：
//        输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行。

import java.util.*;

public class DFS_Stack {
    static List<String> res = new ArrayList<>();   //存放结果，也就是所有可能的出站序列

    public String setTrains(int[] trains) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            res.clear();
//            int n = in.nextInt();//火车的数量
//            int[] trains = new int[n];//存放火车编号
        Stack<Integer> station = new Stack<>();//用栈表示车站，只能先进后出
//            for (int i = 0; i < n; i++) {
//                trains[i] = in.nextInt();
//            }
        trainOut(trains, 0, station, "", 0);
        Collections.sort(res);//输出以字典序从小到大排序的火车出站序列号
        String result = "|";
        for (String s : res) {
//                System.out.println(s);
            result = result + s + "|";
        }
//        }
//        in.close();

        return result;
    }

    public void trainOut(int[] trains, int in, Stack<Integer> station, String res_temp, int out) {
        if (out == trains.length) {   //out表示已经出站的火车数量。当所有火车出站时，表示一个出站序列完成，将其添加到结果中
            res.add(res_temp);
        }
        if (!station.empty()) {  //当车站还有火车时
            int train = station.pop();  //出站一辆火车
            trainOut(trains, in, station, res_temp + train + " ", out + 1);//该出站火车添加到当前出站序列红，出站火车数量+1
            station.push(train);
        }
        if (in < trains.length) { //当还有火车未进站时
            station.push(trains[in]);//进站一辆火车
            trainOut(trains, in + 1, station, res_temp, out);//已进站火车数量+1
            station.pop();
        }
    }
}
