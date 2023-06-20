package com.example.java_practice.ListNode;

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }

        //copy list RandomNode
        RandomNode cur = head;
        while (cur != null) {
            RandomNode next = cur.next;
            cur.next = new RandomNode(cur.val);
            cur.next.next = next;
            cur = next;
        }

        //copy random RandomNode
        cur = head;
        while (cur != null) {
            RandomNode curNew = cur.next;
            curNew.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        //split A-A1-B-B1 to A-B and A1-B1
        RandomNode headNew = head.next;
        cur = head;
        RandomNode curNew = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            curNew.next = cur == null ? null : cur.next;
            curNew = curNew.next;
        }

        return headNew;
    }
}
