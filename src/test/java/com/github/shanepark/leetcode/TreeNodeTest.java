package com.github.shanepark.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNodeTest {

    @Test
    void getMaxDepth() {
        assertThat(TreeNode.of(new Integer[]{10, 5, 15, 3, 7, null, 18}).getMaxDepth()).isEqualTo(3);
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
    void equals() {
        TreeNode root1 = TreeNode.of(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        TreeNode root2 = TreeNode.of(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        TreeNode root3 = TreeNode.of(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, null});
        TreeNode root4 = TreeNode.of(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null});
        assertThat(root1.equals(root2)).isTrue();
        assertThat(root1.equals(root3)).isTrue();
        assertThat(root1.equals(root4)).isFalse();
    }

    @Test
    public void printTree() {
        TreeNode root = TreeNode.of(1, null, 2, 3, 4, null, null, 5, 6);
        root.printTree();
    }

}
