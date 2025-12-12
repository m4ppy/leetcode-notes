"""
LeetCode 94. Binary Tree Inorder Traversal
Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
Difficulty: Easy
Primary: Tree
Tags: [tree, binary-tree, dfs, recursion, stack]
Solved: 2025-11-13
"""

from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    # --- Approach 1: Depth First Search ---
    # Time: O(n), Space: O(n)
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def dfs(node):
            if not node:
                return
            
            dfs(node.left)
            res.append(node.val)
            dfs(node.right)
        
        dfs(root)
        return res
    
    # --- Approach 2: Iterative DFS ---
    # Time: O(n), Space: O(n)
    def inorderTraversal_iterative(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        stack = []
        cur = root

        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right
        
        return res    
    

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()

    root1 = TreeNode(1, None, TreeNode(2, TreeNode(3), None))
    print(solution.inorderTraversal(root1))  # Output: [1, 3, 2]