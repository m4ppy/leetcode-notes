# 1. Two Sum

**Link:** [LeetCode 102 - Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)  
**Difficulty:** Medium
**Primary Topic:** Tree
**Tags:** [tree, binary-tree, bfs, queue, traversal]  
**Languages:** Python, Java  
**Solved:** 2025-11-13

---

### 🧩 Problem Summary
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

---

### 🧠 Approaches

#### Approach 1: Breath First Search
- Use queue to BFS tree.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n) 

#### Approach 2: Depth First Search
- While searching the tree, append it's value to proper depth list inside res.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`102_binary_tree_level_order_traversal.py`](./102_binary_tree_level_order_traversal.py) |
| Java | [`102_binary_tree_level_order_traversal.java`](./102_binary_tree_level_order_traversal.java) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
