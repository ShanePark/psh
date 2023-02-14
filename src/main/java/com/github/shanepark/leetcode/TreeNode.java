package com.github.shanepark.leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * This class was written to help leetcode TreeNode problems testing.
 * <p>
 * Author: Shane
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getMaxDepth() {
        return depthDFS(this, 1);
    }

    public static TreeNode of(Integer... elements) {
        if (elements == null || elements.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(elements[0]);
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < elements.length) {
            TreeNode node = queue.poll();
            if (elements[i] != null) {
                node.left = new TreeNode(elements[i]);
                queue.add(node.left);
            }
            i++;

            if (i < elements.length && elements[i] != null) {
                node.right = new TreeNode(elements[i]);
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }

    @Deprecated
    public static TreeNode ofWithNull(Integer... elements) {
        if (elements == null || elements.length == 0)
            return null;
        TreeNode node = new TreeNode(elements[0]);

        for (int i = 1; i < elements.length; i++) {
            if (elements[i] == null)
                continue;
            Stack<Boolean> isLeftStack = new Stack<>();
            int cur = i;
            while (cur > 0) {
                int head = (cur - 1) / 2;
                boolean isLeft = (head == 0) ? cur == 1 : (cur - 1) % (head * 2) == 0;
                isLeftStack.push(isLeft);
                cur = head;
            }

            traverse(node, isLeftStack, elements[i]);
        }
        return node;
    }

    public void printTree() {
        class TreeNodeWithDepth {
            TreeNode node;
            int depth;

            public TreeNodeWithDepth(TreeNode node, int depth) {
                this.depth = depth;
                this.node = node;
            }
        }

        Queue<TreeNodeWithDepth> q = new LinkedList<>();
        int maxDepth = this.getMaxDepth();
        q.offer(new TreeNodeWithDepth(this, 1));
        int index = 0;
        while (!q.isEmpty()) {
            TreeNodeWithDepth cur = q.poll();
            int depth = cur.depth;
            TreeNode node = cur.node;
            System.out.printf("[%2d] %s\n", index++, (node == null ? "null" : node.val));
            if (node != null && depth < maxDepth) {
                q.add(new TreeNodeWithDepth(node.left, depth + 1));
                q.add(new TreeNodeWithDepth(node.right, depth + 1));
            }
        }
    }

    private int depthDFS(TreeNode node, int depth) {
        if (node == null)
            return depth - 1;
        return Math.max(depthDFS(node.left, depth + 1), depthDFS(node.right, depth + 1));
    }

    private static void traverse(TreeNode node, Stack<Boolean> isLeftStack, int value) {
        boolean isLeft = isLeftStack.pop();
        if (isLeftStack.isEmpty()) {
            if (isLeft) {
                node.left = new TreeNode(value);
            } else {
                node.right = new TreeNode(value);
            }
            return;
        }

        traverse(isLeft ? node.left : node.right, isLeftStack, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
