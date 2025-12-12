# 1. Two Sum

**Link:** [LeetCode 200 - Number of Islands](https://leetcode.com/problems/number-of-islands/)  
**Difficulty:** Medium
**Primary Topic:** Graph
**Tags:** [graph, bfs, dfs, matrix, connected-components]  
**Languages:** Python, Java  
**Solved:** 2025-11-14

---

### 🧩 Problem Summary
Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

---

### 🧠 Approaches

#### Approach 1: Depth First Search
- Traverse the 2D grid by DFS, mark the visited island as '0'.
- m is number of rows, and n is number of columns in grid.
- **Time Complexity:** O(m * n)  
- **Space Complexity:** O(m * n) 

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`200_number_of_islands.py`](./200_number_of_islands.py) |
| Java | [`200_number_of_islands.java`](./200_number_of_islands.java) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
