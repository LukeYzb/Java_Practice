package com.example.java_practice.HuaweiOD;

//        题目描述:
//        有N个快递站点用字符串标识，某些站点之间有道路连接。每个站点有一些包裹要运输，每个站点间的包裹不重复路上有检查站会导致部分货物无法通行，计算哪些货物无法正常投递
//        输入描述:第一行输入M N，M个包裹N个道路信息.0<=M,N<=100，检查站禁止通行的包裹如果有多个以空格分开
//        4 2
//        package1 A C
//        package2 A C
//        package3 B C
//        package4 A C
//        A B package1
//        A C package2 package4
//        输出描述:
//        输出不能送达的包裹 package2 package4,如果所有包裹都可以送达则输出none，输出结果按照升序排列

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BFS_Map_PackageDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        /**
         * key：包裹名
         * value：运输路径
         */
        Map<String, String> mapPkg = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String[] strings = sc.nextLine().split(" ");
            mapPkg.put(strings[0], strings[1] + strings[2]);
        }

        /**
         * key：路径名
         * value：被拦截的包裹名
         */
        Map<String, List<String>> mapNo = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] strings = sc.nextLine().split(" ");
            List<String> noList = new ArrayList<>();
            for (int j = 2; j < strings.length; j++) {
                noList.add(strings[j]);
            }
            mapNo.put(strings[0] + strings[1], noList);
        }

        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, List<String>> map : mapNo.entrySet()) {
            String key = map.getKey();  //路径名
            List<String> list = map.getValue(); //被拦截的包裹
            for (String s : list) {
                if (key.equals(mapPkg.get(s))) {  //被拦截的包裹的运输路径等于此路径则表示包裹被拦截
                    resList.add(s);
                }
            }
        }

        System.out.println(resList);
    }
}
