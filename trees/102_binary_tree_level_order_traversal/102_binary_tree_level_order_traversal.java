/*
LeetCode 102. Binary Tree Level Order Traversal
Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
Difficulty: Medium
Primary: Tree
Tags: [tree, binary-tree, bfs, queue, traversal]
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
    public List<List<Integer>> levelOrder_bfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (level.size() > 0) {
                res.add(level);
            }
        }
        return res;
    }

    // --- Approach 2: Depth First Search ---
    // Time: O(n), Space: O(n)
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder_dfs(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }

        res.get(depth).add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.levelOrder_bfs(root));  // Expected: [[3], [9, 20], [15, 7]]
    }
    
}