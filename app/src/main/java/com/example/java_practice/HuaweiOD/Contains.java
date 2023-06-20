package com.example.java_practice.HuaweiOD;

//        题目描述:
//        小王在进行游戏大闯关，有一个关卡需要输入一个密码才能通过。密码获得的条件如下:在一个密码本中，每一页都有一个由26个小写字母组成的若干位密码，每一页的密码不同，需要从这个密码本中寻找这样一个最长的密码，从它的末尾开始依次去掉一位得到的新密码也在密码本中存在。请输出符合该要求的密码，如果有多个符合要求的密码，则返回字典序最大的密码。若没有符合要求的密码，则返回空字符串。
//        输入描述:
//        密码本由一个字符串数组组成，不同元素之间使用空格隔开，每一个元素代表密码本每一页的密码
//        输出描述:
//        个字符串
//        补充说明:
//        1 <= 密码本的页数 <= 105
//        1 <= 每页密码的长度 <= 105
//
//        示例1
//        输入:
//        b eredderd bw bww bwwl bwwlm bwwln
//        输出:
//        bwwln
//        说明:
//        "bwwim"和"bwwin"从未尾开始依次去掉一位得到密码在密码本中都存在。但是"bwwin"比"bwwim”字典序排序Q大，所以应该返回"bwwln"

import java.util.*;

public class Contains {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] pwds = input.nextLine().split(" ");
        String ans = "";
        Set<String> all = new HashSet<>();
        for (String s : pwds) {
            all.add(s);
        }
        for (String s : pwds) {
            if (check(s, all)) {
                if (s.length() > ans.length()) {
                    ans = s;
                } else if (s.length() == ans.length() && s.compareTo(ans) > 0) {
                    ans = s;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean check(String s, Set<String> all) {
        for (int i = 0; i < s.length(); i++) {
            //use contains()
            if (!all.contains(s.substring(0, i + 1))) {
                return false;
            }
        }
        return true;
    }
}
