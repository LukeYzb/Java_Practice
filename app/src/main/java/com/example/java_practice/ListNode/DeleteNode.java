package com.example.java_practice.ListNode;

import com.example.java_practice.ListNode.SingleListNode;

//Definition for singly-linked list.
class SingleListNode {
    int val;
    SingleListNode next;

    SingleListNode(int x) {
        val = x;
        next = null;
    }
}

public class DeleteNode {
    public SingleListNode deleteNode(SingleListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        SingleListNode temp = head.next;
        SingleListNode pre = head;

        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
                return head;
            }
            temp = temp.next;
            pre = pre.next;

        }

        return head;
    }
}
