package com.github.shanepark.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeTest {

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
