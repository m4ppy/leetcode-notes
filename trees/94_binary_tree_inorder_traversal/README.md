# 94. Binary Tree Inorder Traversal

**Link:** [LeetCode 94 - Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)  
**Difficulty:** Easy
**Primary Topic:** Tree
**Tags:** [tree, binary-tree, dfs, recursion, stack]  
**Languages:** Python, Java  
**Solved:** 2025-11-13

---

### 🧩 Problem Summary
Given the root of a binary tree, return the inorder traversal of its nodes' values.

---

### 🧠 Approaches

#### Approach 1: Depth First Search
- DFS the tree inorder.
- call stack -> O(n) time, output array -> O(n) space.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n) 

#### Approach 2: Iterative DFS
- Iterate the tree inorder by stack.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`94_binary_tree_inorder_traversal.py`](./94_binary_tree_inorder_traversal.py) |
| Java | [`94_binary_tree_inorder_traversal.java`](./94_binary_tree_inorder_traversal.java) |

---

### ✅ Example
```python
Input: root = [1,null,2,3]
Output: [1,3,2]
