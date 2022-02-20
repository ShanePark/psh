package com.tistory.shanepark.leetcode;

import java.util.LinkedList;
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

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getMaxDepth() {
        return depthDFS(this, 1);
    }

    public static TreeNode makeTree(Integer[] arr) {
        if (arr.length == 0)
            return null;
        TreeNode node = new TreeNode(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == null)
                continue;
            Stack<Boolean> isLeftStack = new Stack<>();
            int cur = i;
            while (cur > 0) {
                int head = (cur - 1) / 2;
                boolean isLeft = (head == 0) ? cur == 1 : (cur - 1) % (head * 2) == 0;
                isLeftStack.push(isLeft);
                cur = head;
            }

            traverse(node, isLeftStack, arr[i]);
        }
        return node;

    }

    public void printTree() {
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

    static class TreeNodeWithDepth {
        TreeNode node;
        int depth;

        public TreeNodeWithDepth(TreeNode node, int depth) {
            this.depth = depth;
            this.node = node;
        }
    }

}
