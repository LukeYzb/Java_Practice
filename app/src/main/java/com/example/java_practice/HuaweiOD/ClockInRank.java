package com.example.java_practice.HuaweiOD;

//        题目描述:
//        公司某部门软件教导团正在组织新员工每日打卡学习活动，他们开展这项学习活动已经一个月了，所以想统计下这个月优秀的打卡员工。每个员工会对应一个id，每天的打卡记录记录当天打卡员工的id集合，一共30天
//        请你实现代码帮助统计出打卡次数top5的员工。假如打卡次数相同，将较早参与打卡的员工排在前面，如果开始参与打卡的时间还是一样，将id较小的员工排在前面。
//        注: 不考虑并列的情况，按规则返回前5名员工的id即可，如果当月打卡的员工少于5个，按规则排序返回所有有打卡记录的员工id。
//
//        输入描述:
//        第一行输入为新员工数量N，表示新员工编号id为0到N-1，N的范围为[1,100]第二行输入为30个整数，表示每天打卡的员工数量，每天至少有1名员工打卡之后30行为每天打卡的员工id集合，id不会重复
//        输出描述:
//        按顺序输出打卡top5员工的id，用空格隔开
//        补充说明:
//        同一天打卡的员工没有时间上早晚的区别。不保证所有员工都会打卡。排名只针对有打卡记录的员工。
//
//        示例1
//        输入:
//        4
//        1 4 4 1
//        0
//        0 7 1 10
//        0 2 6 10
//        10
//        输出:
//        0 10 1 7 2
//        说明:
//        0和10并列打卡次数最多，0最早参与打卡排10前面，1，7，2，6均打卡一次，1和7同时在第二天参与打卡，1比7小排7前面，2和6同理2排前面。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ClockInRank {//map to list, sort list

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        /**
         * 使用map来放置员工打卡情况
         * key：员工工号
         * value：int[]员工打卡情况
         *          int[0]：第一次打开时间
         *          int[1]：总打卡数
         */
        Map<Integer, int[]> map = new HashMap<>();
        int[] dayInts = new int[30];    //30天每天的打卡人数
        for (int i = 0; i < 30; i++) {
            dayInts[i] = sc.nextInt();
        }

        for (int i = 0; i < 30; i++) {

            for (int j = 0; j < dayInts[i]; j++) {    //用30天每天的打卡人数控制输入
                int input = sc.nextInt();
                if (input > N - 1) {      //输入值大于员工总数（工号从0开始）
                    continue;
                }
                int[] temp = new int[2];
                if (map.containsKey(input)) {
                    temp = map.get(input);
                    ++temp[1];
                } else {
                    temp[0] = i;
                    temp[1] = 1;
                }
                map.put(input, temp);
            }

        }

        List<Map.Entry<Integer, int[]>> mapList = new ArrayList<>(map.entrySet());  //将map转化为list进行排序
        mapList.sort((a, b) -> {
            if (b.getValue()[1] < a.getValue()[1]) {      //天数多的靠前
                return -1;
            } else if (b.getValue()[1] == a.getValue()[1]) {
                if (b.getValue()[0] > a.getValue()[0]) {      //天数相同的第一次打卡时间靠前
                    return -1;
                }
            }
            return 1;
        });

        String res = "";
        for (int i = 0; i < (mapList.size() < 5 ? mapList.size() : 5); i++) {     //小于5的取所有，大于5的只取5
            res += mapList.get(i).getKey() + " ";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }

}

class ClockInRank1 {//use compareTo() in Comparable for sort

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //人数
        int N = Integer.parseInt(in.nextLine());
        PriorityQueue<Man> queue = new PriorityQueue<>();
        int day = 0;
        HashMap<Integer, Man> map = new HashMap<>();
        in.nextLine();
        while (day < 30) {
            String[] list = in.nextLine().split(" ");
            for (String s : list) {
                int cur = Integer.parseInt(s);
                if (!map.containsKey(cur)) {
                    Man man = new Man(cur, 0, -1);
                    map.put(cur, man);
                }
                Man man = map.get(cur);
                man.count = man.count + 1;
                man.start = man.start == -1 ? day : man.start;
            }
            day++;
        }
        for (Map.Entry<Integer, Man> entry : map.entrySet()) {
            queue.offer(entry.getValue());
        }

        for (int i = 0; i < 5; i++) {
            Man man = queue.poll();
            System.out.print(man.id + " ");
            if (queue.isEmpty())
                break;
        }
    }

    static class Man implements Comparable {
        int id;
        int count;
        int start;

        public Man(int id, int count, int start) {
            this.id = id;
            this.count = count;
            this.start = start;
        }

        @Override
        public int compareTo(Object o) {
            Man other = (Man) o;
            if (this.count != other.count) {
                return other.count - this.count;
            } else {
                if (this.start != other.start) {
                    return this.start - other.start;
                } else {
                    return this.id - other.id;
                }
            }
        }
    }
}
