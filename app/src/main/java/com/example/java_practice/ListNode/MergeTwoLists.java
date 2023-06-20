package com.example.java_practice.ListNode;

import com.example.java_practice.ListNode.SingleListNode;

public class MergeTwoLists {
    public SingleListNode mergeTwoLists(SingleListNode l1, SingleListNode l2) {
        SingleListNode merge = new SingleListNode(0);
        SingleListNode temp = merge;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        temp.next = l1 == null ? l2 : l1;

        return merge.next;
    }

    //recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l2.next, l1);
        return l2;
    }
}
