package com.github.shanepark.leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

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

        for (int i = 1; i < elements.length; i++) {
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
        }

        return root;
    }

    public void printTree() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        int index = 0;
        boolean hasNext = true;
        while (hasNext) {
            StringBuilder line = new StringBuilder();
            hasNext = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll != null) {
                    hasNext = true;
                    q.offer(poll.left);
                    q.offer(poll.right);
                    line.append(String.format("[%2d] %d\n", index++, poll.val));
                } else {
                    q.offer(null);
                    q.offer(null);
                    line.append(String.format("[%2d] null\n", index++));
                }
            }
            if (hasNext)
                sb.append(line);
        }
        System.out.println(sb);
    }

    private int depthDFS(TreeNode node, int depth) {
        if (node == null)
            return depth - 1;
        return Math.max(depthDFS(node.left, depth + 1), depthDFS(node.right, depth + 1));
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
