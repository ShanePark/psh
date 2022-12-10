package com.tistory.shanepark.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class TreeNodeTest {

    @Test
    void getMaxDepth() {
        assertThat(TreeNode.ofWithNull(new Integer[]{10, 5, 15, 3, 7, null, 18}).getMaxDepth()).isEqualTo(3);
    }

    @Test
    void ofWithNull() {
        TreeNode root = TreeNode.ofWithNull(new Integer[]{10, 5, 15, 3, 7, null, 18});
        assertThat(root.val).isEqualTo(10);
        assertThat(root.left.val).isEqualTo(5);
        assertThat(root.right.val).isEqualTo(15);
        assertThat(root.left.left.val).isEqualTo(3);
        assertThat(root.left.right.val).isEqualTo(7);
        assertThat(root.right.left).isNull();
        assertThat(root.right.right.val).isEqualTo(18);


        root = TreeNode.ofWithNull(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        assertThat(root.val).isEqualTo(0);
        assertThat(root.left.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(3);
        assertThat(root.left.right.val).isEqualTo(4);
        assertThat(root.right.left.val).isEqualTo(5);
        assertThat(root.right.right.val).isEqualTo(6);
        assertThat(root.left.left.left.val).isEqualTo(7);
        assertThat(root.left.left.right.val).isEqualTo(8);
        assertThat(root.left.right.left.val).isEqualTo(9);
        assertThat(root.left.right.right.val).isEqualTo(10);
        assertThat(root.right.left.left.val).isEqualTo(11);
        assertThat(root.right.left.right.val).isEqualTo(12);
        assertThat(root.right.right.left.val).isEqualTo(13);
        assertThat(root.right.right.right.val).isEqualTo(14);
    }

    @Test
    void ofWithNull2() {
        TreeNode root = TreeNode.ofWithNull(10, 5, 15, 3, 7, null, 18);
        assertThat(root.val).isEqualTo(10);
        assertThat(root.left.val).isEqualTo(5);
        assertThat(root.right.val).isEqualTo(15);
        assertThat(root.left.left.val).isEqualTo(3);
        assertThat(root.left.right.val).isEqualTo(7);
        assertThat(root.right.left).isNull();
        assertThat(root.right.right.val).isEqualTo(18);

        TreeNode nullNode = TreeNode.ofWithNull();
        assertThat(nullNode).isNull();

        TreeNode nullNode2 = TreeNode.ofWithNull(null, null);
        assertThat(nullNode2).isNull();
    }

    @Test
    public void of() {
        TreeNode root = TreeNode.of(1, null, 2, 3, 4, null, null, 5, 6);
        assertThat(root.val).isEqualTo(1);
        assertThat(root.left).isNull();
        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.right.left.val).isEqualTo(3);
        assertThat(root.right.right.val).isEqualTo(4);
        assertThat(root.right.right.left.val).isEqualTo(5);
        assertThat(root.right.right.right.val).isEqualTo(6);
    }

    @Test
    public void of2() {
        TreeNode root = TreeNode.of(1, null, 2, null, 3, null, 4, null, 5);
        assertThat(root.val).isEqualTo(1);
        assertThat(root.left).isNull();
        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.right.left).isNull();
        assertThat(root.right.right.val).isEqualTo(3);
        assertThat(root.right.right.left).isNull();
        assertThat(root.right.right.right.val).isEqualTo(4);
        assertThat(root.right.right.right.left).isNull();
        assertThat(root.right.right.right.right.val).isEqualTo(5);
    }

    @Test
    void printTree() {
        TreeNode.ofWithNull(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}).printTree();
    }

    @Test
    void equals() {
        TreeNode root1 = TreeNode.ofWithNull(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        TreeNode root2 = TreeNode.ofWithNull(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        TreeNode root3 = TreeNode.ofWithNull(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, null});
        TreeNode root4 = TreeNode.ofWithNull(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null});
        assertThat(root1.equals(root2)).isTrue();
        assertThat(root1.equals(root3)).isTrue();
        assertThat(root1.equals(root4)).isFalse();
    }

}
