/*
LeetCode 94. Binary Tree Inorder Traversal
Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
Difficulty: Easy
Primary: Tree
Tags: [tree, binary-tree, dfs, recursion, stack]
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

    // --- Approach 1: Depth First Search ---
    // Time: O(n), Space: O(n)
    private List<Integer> res;

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }

    public List<Integer> inorderTraversal_dfs(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }


    // --- Approach 2: Iterative DFS ---
    // Time: O(n), Space: O(n)
    public List<Integer> inorderTraversal_iterativeDfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(sol.inorderTraversal_dfs(root1));  // Output: [1, 3, 2]
    }
    
}