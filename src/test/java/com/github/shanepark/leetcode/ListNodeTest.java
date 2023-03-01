package com.github.shanepark.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeTest {

    @Test
    void allArgsConstructor() {
        ListNode listNode = new ListNode(0, null);
        assertThat(listNode.val).isEqualTo(0);
        assertThat(listNode.next).isNull();
    }

    @Test
    void equalsTest() {
        ListNode listNode1 = new ListNode(0, null);
        ListNode listNode2 = new ListNode(0, null);
        ListNode listNode3 = new ListNode(0, listNode2);
        ListNode listNode4 = new ListNode(1);
        assertThat(listNode1).isEqualTo(listNode1);
        assertThat(listNode1).isEqualTo(listNode2);
        assertThat(listNode1).isNotEqualTo(null);
        assertThat(listNode1).isNotEqualTo(1);
        assertThat(listNode1).isNotEqualTo(listNode3);
        assertThat(listNode1).isNotEqualTo(listNode4);
    }

    @Test
    void hashCodeTest() {
        ListNode listNode1 = new ListNode(0, null);
        ListNode listNode2 = new ListNode(0, null);
        assertThat(listNode1.hashCode()).isEqualTo(listNode2.hashCode());
    }

    @Test
    public void testToString() {
        String str = ListNode.of(1, 2, 3, 4, 5).toString();
        assertThat(str).isEqualTo("ListNode{val=1, next=ListNode{val=2, next=ListNode{val=3, next=ListNode{val=4, next=ListNode{val=5, next=null}}}}}");
    }

    @Test
    void testOf() {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = ListNode.of(arr);
        ListNode head2 = ListNode.of(1, 2, 3, 3, 4, 4, 5);
        assertThat(head).isEqualTo(head2);
        assertThat(head).isEqualTo(ListNode.of(1, 2, 3, 3, 4, 4, 5));

        head.print();

        for (int i = 0; i < arr.length; i++) {
            assertThat(head.val).isEqualTo(arr[i]);
            assertThat(head2.val).isEqualTo(arr[i]);
            head = head.next;
            head2 = head2.next;
        }
    }
}
