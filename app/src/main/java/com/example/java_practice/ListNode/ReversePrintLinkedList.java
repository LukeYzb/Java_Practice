package com.example.java_practice.ListNode;

import com.example.java_practice.ListNode.ListNode;

public class ReversePrintLinkedList {
    public int[] reversePrint(ListNode head) {
        //empty input
        if (head == null) {
            return new int[0];
        }

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int[] res = new int[count];
        int k = count - 1;
        while (head != null) {
            res[k--] = head.val;
            head = head.next;
        }

        return res;
    }
}
