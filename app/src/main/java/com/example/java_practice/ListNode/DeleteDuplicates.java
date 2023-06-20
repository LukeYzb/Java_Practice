package com.example.java_practice.ListNode;

public class DeleteDuplicates {
    //recursion
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode currNode = head;
        while (currNode.next != null) {
            if (currNode.next.val == currNode.val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }

        return head;
    }
}
