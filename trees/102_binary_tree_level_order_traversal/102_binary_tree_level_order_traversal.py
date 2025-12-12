"""
LeetCode 102. Binary Tree Level Order Traversal
Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
Difficulty: Medium
Primary: Tree
Tags: [tree, binary-tree, bfs, queue, traversal]
Solved: 2025-11-13
"""

from typing import List, Optional
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    # --- Approach 1: Breath First Search ---
    # Time: O(n), Space: O(n)
    def levelOrder_bfs(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = collections.deque()
        res = []

        if root:
            q.append(root)
            
        while q:
            level = []
            for _ in range(len(q)):
                cur = q.popleft()
                level.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            res.append(level)

        return res
    
    # --- Approach 2: Depth First Search ---
    # Time: O(n), Space: O(n)
    def levelOrder_dfs(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []

        def dfs(node, depth):
            if not node:
                return
            if len(res) == depth:
                res.append([])

            res[depth].append(node.val)
            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)
        
        dfs(root, 0)
        return res   
    

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()
    
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print(solution.levelOrder(root))  # Expected: [[3], [9, 20], [15, 7]]