package com.github.shanepark.leetcode;

import java.util.Objects;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
