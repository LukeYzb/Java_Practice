package com.example.java_practice.ListNode;

import com.example.java_practice.ListNode.ListNode;

public class ReverseLinkedList {


    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);

    //iterate
    public ListNode iterate(ListNode head) {
        ListNode curr = head, pre = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //recursion
    public ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    //original node list
    public String origin() {
        ListNode node;
        node = node1;
        String res = node1.val + "";
        while (node.next != null) {
            node = node.next;
            res += node.val;
        }

        return res;
    }

    //result
    public String res() {
        //iterate
//        ListNode pre = iterate(node1);

        //recursion
        ListNode pre = recursion(node1);

        ListNode node;
        node = pre;
        String res = pre.val + "";
        while (node.next != null) {
            node = node.next;
            res += node.val;
        }

        return res;
    }
}
