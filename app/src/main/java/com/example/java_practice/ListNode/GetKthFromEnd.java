package com.example.java_practice.ListNode;

import com.example.java_practice.ListNode.ListNode;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
