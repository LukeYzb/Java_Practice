package com.example.java_practice.HuaweiOD;

//        小王设计了一个简单的猜字谜游戏，游戏的谜面是一个错误的单词，比如nesw，玩家需要猜出谜底库中正确的单词。猜中的要求如下：
//        对于某个谜面和谜底单词，满足下面任一条件都表示猜中：
//        1）变换顺序以后一样的，比如通过变换w和e的顺序，“nwes”跟“news”是可以完全对应的；
//        2）字母去重以后是一样的，比如“woood”和“wood”是一样的，它们去重后都是“wod”
//        请你写一个程序帮忙在谜底库中找到正确的谜底。谜面是多个单词，都需要找到对应的谜底，如果找不到的话，返回"not found"
//
//        输入描述：
//        1、谜面单词列表，以","分隔
//        2、谜底库单词列表，以","分隔
//        输出描述：
//        匹配到的正确单词列表，以“,”分隔
//        如果找不到，返回"not found"
//        补充说明：
//        1、单词的数量N的范围：0 < N < 1000
//        2、词汇表的数量M的范围： 0 < M < 1000
//        3、单词的长度P的范围：0 < P < 20
//        4、输入的字符只有小写英文字母，没有其它字符
//
//        示例1
//        输入:
//        conection
//        connection,today
//        输出:
//        connection
//        示例2
//        输入:
//        bdni,woooodbind,wrong,wood
//        输出:
//        bind,wood
//
//        解题思路:
//        使用双层循环。外层是谜面，内层是谜底。
//        1.判断变换顺序后是否一致: 将两个字符串变为数组后进行排序，如果排序后的数组一致，则表示变序后一致2.去重后是否一致:将两个字符串去重后加入列表中，如果两个列表一致，则表示去重后一致。
//        3.1和2都符合，则添加字符串“not found”

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordPuzzle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] mimian = sc.nextLine().split(",");
        String[] midi = sc.nextLine().split(",");

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < mimian.length; i++) {
            String mm = mimian[i];  //谜面
            boolean isFound = false;    //是否存在谜底
            for (int j = 0; j < midi.length; j++) {
                String md = midi[j];    //谜底
                if (bianxu(mm, md)) {
                    resList.add(md);
                    isFound = true;
                } else if (quchong(mm, md)) {
                    resList.add(md);
                    isFound = true;
                }
            }
            if (!isFound) {
                resList.add("not found");
            }
        }

        String res = "";
        for (int i = 0; i < resList.size(); i++) {
            res += resList.get(i) + ",";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }

    /**
     * 变序后谜面和谜底是否一致
     *
     * @param miman
     * @param midi
     * @return
     */
    public static boolean bianxu(String miman, String midi) {

        String[] mmStrs = miman.split("");
        Arrays.sort(mmStrs);
        String[] midiStrs = midi.split("");
        Arrays.sort(midiStrs);

        if (Arrays.equals(mmStrs, midiStrs)) {
            return true;
        }

        return false;
    }

    /**
     * 去重后谜面与谜底是否一致
     *
     * @param miman
     * @param midi
     * @return
     */
    public static boolean quchong(String miman, String midi) {

        List<Character> mmList = new ArrayList<>();
        for (int i = 0; i < miman.length(); i++) {
            char c = miman.charAt(i);
            if (!mmList.contains(c)) {
                mmList.add(c);
            }
        }

        List<Character> midiList = new ArrayList<>();
        for (int i = 0; i < midi.length(); i++) {
            char c = midi.charAt(i);
            if (!midiList.contains(c)) {
                midiList.add(c);
            }
        }

        if (mmList.equals(midiList)) {
            return true;
        }
        return false;

    }

}

class WordPuzzle1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] question = in.nextLine().split(",");
        String[] answer = in.nextLine().split(",");

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < question.length; i++) {
            String q = question[i];
            boolean isFound = false;
            for (int j = 0; j < answer.length; j++) {
                String a = answer[j];
                if (change(q, a)) {
                    resList.add(a);
                    isFound = true;
                } else if (dist(q, a)) {
                    resList.add(a);
                    isFound = true;
                }
            }
            if (!isFound) {
                resList.add("not found");
            }
        }
        String res = "";
        for (int i = 0; i < resList.size(); i++) {
            res += resList.get(i) + ",";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }

    public static boolean dist(String question, String answer) {
        List<Character> qList = new ArrayList<>();
        for (int i = 0; i < question.length(); i++) {
            char c = question.charAt(i);
            if (!qList.contains(c)) {
                qList.add(c);
            }
        }
        List<Character> aList = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (!aList.contains(c)) {
                aList.add(c);
            }
        }
        if (qList.equals(aList)) {
            return true;
        }
        return false;

    }

    public static boolean change(String question, String answer) {
        String[] qStr = question.split("");
        Arrays.sort(qStr);
        String[] aStr = answer.split("");
        Arrays.sort(aStr);
        if (Arrays.equals(qStr, aStr)) {
            return true;
        }
        return false;
    }
}
