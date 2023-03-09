package io.github.shanepark.leetcode;

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
        assertThat(listNode1).isNotEqualTo(new Object());
        assertThat(listNode1).isNotEqualTo(listNode3);
        assertThat(listNode1).isNotEqualTo(listNode4);
    }

    @Test
    public void isCycleTest() {
        ListNode node = ListNode.of(1, 2, 3);
        assertThat(node.isCycle()).isFalse();
        node.next.next.next = node;
        node.print();
        assertThat(node.isCycle()).isTrue();

        ListNode node2 = ListNode.of(1, 2, 3, 4);
        assertThat(node2.isCycle()).isFalse();
        node2.next.next.next.next = node2.next.next;
        assertThat(node2.isCycle()).isTrue();

        assertThat(ListNode.of(1).isCycle()).isFalse();
    }

    @Test
    public void equalsAndHashcodeForListNodeWithCycle() {
        // Given
        ListNode node = ListNode.of(1, 2, 3);
        node.next.next.next = node;
        ListNode node2 = ListNode.of(1, 2, 3);
        node2.next.next.next = node2;

        // Then
        assertThat(node.isCycle()).isTrue();
        assertThat(node).isEqualTo(node2);
        assertThat(node).isNotEqualTo(ListNode.of(1, 2, 3));
        assertThat(node.hashCode()).isEqualTo(node2.hashCode());
    }

    @Test
    public void equalsAndHashcodeForListNodeWithCycle2() {
        // Given
        ListNode node1 = ListNode.of(1, 2, 3, 4, 5);
        node1.next.next.next.next.next = node1.next.next;
        ListNode node2 = ListNode.of(1, 2, 3, 4, 5);
        node2.next.next.next.next.next = node2.next.next;

        // then
        assertThat(node1).isEqualTo(node2);
        node2.next.next.next.next.next = node2.next;
        assertThat(node1).isNotEqualTo(node2);

        node2.next.next.next.next.next = node2.next.next;
        assertThat(node1).isEqualTo(node2);
        node2.val = 2;
        assertThat(node1).isNotEqualTo(node2);

        node2.val = 1;
        node2.next.val = 1;
        assertThat(node1).isNotEqualTo(node2);

        node2.next.val = 2;
        node2.next.next.val = 1;
        assertThat(node1).isNotEqualTo(node2);
    }

    @Test
    void hashCodeTest() {
        ListNode listNode1 = new ListNode(0, null);
        ListNode listNode2 = new ListNode(0, null);
        assertThat(listNode1.hashCode()).isEqualTo(listNode2.hashCode());
    }

    @Test
    public void testToString() {
        ListNode node = ListNode.of(1, 2, 3, 4, 5);
        assertThat(node.toString()).isEqualTo("ListNode{val=1, next=ListNode{val=2, next=ListNode{val=3, next=ListNode{val=4, next=ListNode{val=5, next=null}}}}}");
        ListNode last = node.next.next.next.next;
        assertThat(last.val).isEqualTo(5);
        last.next = node.next.next;
        assertThat(node.isCycle()).isTrue();
        assertThat(node.toString()).isEqualTo("[cycle] 1");
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
