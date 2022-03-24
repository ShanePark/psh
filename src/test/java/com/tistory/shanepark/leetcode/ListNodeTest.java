package com.tistory.shanepark.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ListNodeTest {

    @Test
    void of() {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = ListNode.of(arr);

        head.print();

        for (int i = 0; i < arr.length; i++) {
            Assertions.assertThat(head.val).isEqualTo(arr[i]);
            head = head.next;
        }
    }
}
