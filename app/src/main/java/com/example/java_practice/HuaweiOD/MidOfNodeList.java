package com.example.java_practice.HuaweiOD;

//        题目描述:
//        给定一个单链表。 L，请编写程序输出 L 中间结点保存的数据。如果有两个中间结点，则输出第二个中间结点保存的数据。例如: 给定L为 1-7一5，则输出应该为 7; 给定L为 12-3一4，则输出应该为 3。
//        输入描述:
//        每个输入包含 1个测试用例。每个测试用例第 1 行给出链表首结点的地址、结点总个数正整数 N 105)。结点的地址是 5 位非负整数，NULL 地址用 -1 表示
//        接下来有 N 行，每行格式为
//        Address Data Next
//        其中 Address 是结点地址，Data 是该结点保存的整数数据(0  Data s 108)，Next 是下一结点的地址
//        输出描述:
//        对每个测试用例，在一行中输出 L 中间结点保存的数据。如果有两个中间结点，则输出第二个中间结点保存的数据.补充说明:
//        已确保输入的结点所构成的链表 L 不会成环，但会存在部分输入结点不属于链表 L 情况。
//
//        示例1
//        输入:
//        00100 4
//        00000 4 -1
//        00100 1 12309
//        33218 3 00000
//        12309 2 33218
//        输出:
//        3
//        示例2
//        输入:
//        10000 3
//        76892 7 12309
//        12309 5 -1
//        10000 1 76892
//        输出:
//        7

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidOfNodeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputFirst = sc.nextLine().split(" ");
        int n = Integer.parseInt(inputFirst[1]);

        //用来存放链表数据
        List<String[]> list = new ArrayList<>();
        Node head = null;
        for (int i = 0; i < n; i++) {
            String[] inp = sc.nextLine().split(" ");
            if (inp[0].equals(inputFirst[0])) {
                //头部节点的下一个节点
                Node nextNode = new Node(inp[2], 0, new Node());
                //头部节点
                head = new Node(inp[0], Integer.valueOf(inp[1]), nextNode);
            } else {
                list.add(inp);
            }
        }


        Node node = head;
        while (node.next != null) {

            String addr = node.next.addr;

            for (int i = 0; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[0].equals(addr)) {
                    Node nextNode = null;
                    if (!strings[2].equals("-1")) {       //不等于-1表示有next节点
                        nextNode = new Node(strings[2], 0, new Node());
                    }
                    node.next = new Node(strings[0], Integer.valueOf(strings[1]), nextNode);
                    node = node.next;
                    list.remove(i);     //已经统计过的直接剔除
                    break;
                }
            }

        }

        //快指针（走两步）
        Node fast = head;
        //满指针（走一步）
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
    }

    static class Node {
        public String addr;
        public int data;
        public Node next;

        public Node() {
            super();
        }

        public Node(String addr, int data, Node next) {
            this.addr = addr;
            this.data = data;
            this.next = next;

        }
    }
}
