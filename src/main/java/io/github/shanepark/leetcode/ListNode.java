package io.github.shanepark.leetcode;

import java.util.HashMap;
import java.util.Map;
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
        if (isCycle()) {
            Map<ListNode, Integer> map = new HashMap<>();
            ListNode head = this;
            int i = 0;
            while (!map.containsKey(head)) {
                map.put(head, i);
                System.out.println("[" + i++ + "] : " + head.val);
                head = head.next;
            }
            System.out.println("Cycle to [" + map.get(head) + "th index](" + head.val + ")");
            return;
        }
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
        if (o == null || getClass() != o.getClass())
            return false;
        ListNode listNode = (ListNode) o;
        if (isCycle() != listNode.isCycle())
            return false;
        if (!isCycle())
            return val == listNode.val && Objects.equals(next, listNode.next);
        return isEqualCycle(this, listNode);
    }

    private boolean isEqualCycle(ListNode cycle1, ListNode cycle2) {
        if (cycle1.val != cycle2.val || cycle1.next.val != cycle2.next.val) {
            return false;
        }
        ListNode slow1 = cycle1.next, fast1 = cycle1.next.next;
        ListNode slow2 = cycle2.next, fast2 = cycle2.next.next;
        while (slow1 != fast1) {
            slow1 = slow1.next;
            fast1 = fast1.next.next;
            slow2 = slow2.next;
            fast2 = fast2.next.next;
            if (slow1.val != slow2.val || fast1.val != fast2.val)
                return false;
        }
        return true;
    }

    public boolean isCycle() {
        ListNode slow = this;
        ListNode fast = this;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (!isCycle())
            return Objects.hash(val, next);
        int result = 1;
        ListNode slow = this.next, fast = this.next.next;
        while (slow != fast) {
            result = 31 * result + slow.val;
            result = 31 * result + fast.val;
            slow = slow.next;
            fast = fast.next.next;
        }
        return result;
    }

    @Override
    public String toString() {
        if (!isCycle())
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        return "[cycle] " + val;
    }

}
