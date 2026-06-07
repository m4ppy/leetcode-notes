/*
LeetCode 104. Maximum Depth of Binary Tree
Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
Difficulty: Easy
Primary: Tree
Tags: [tree, binary-tree, bfs, dfs, iterative-dfs]
Solved: 2025-11-13
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // --- Approach 1: Breath First Search ---
    // Time: O(n), Space: O(n)
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }


    // --- Approach 2: Depth First Search ---
    // Time: O(n), Space: O(n)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    // --- Approach 3: Iterative DFS ---
    // Time: O(n), Space: O(n)
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int depth = current.getValue();

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return res;
    }

    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        System.out.println(sol.maxDepth(root)); // 3
    }

}
