package com.example.java_practice.ListNode;

import com.example.java_practice.ListNode.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            //loop exists
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        //loop not exist
        return false;
    }
}
