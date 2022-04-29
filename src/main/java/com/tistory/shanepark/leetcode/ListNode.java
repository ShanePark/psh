package com.tistory.shanepark.leetcode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    static public ListNode of(int... arr) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dummy.next;
    }

    public void print() {
        int i = 0;
        ListNode head = this;
        do {
            System.out.println("[" + i++ + "] : " + head.val);
            head = head.next;
        } while (head != null);
    }

}
