# 1. Two Sum

**Link:** [LeetCode 20 - Min Stack](https://leetcode.com/problems/min-stack/)  
**Difficulty:** Medium
**Primary Topic:** Stack
**Tags:** [design, stack, data-structure, optimization]  
**Languages:** Python, Java  
**Solved:** 2025-11-12

---

### 🧩 Problem Summary
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

---

### 🧠 Approaches

#### Approach 1: One Stack
- Each node in stack has a current minimum value.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1) 

#### Approach 2: Two Stack
- Use another stack that has current minimum value.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`155_min_stack.py`](./155_min_stack.py) |
| Java | [`155_min_stack.java`](./155_min_stack.java) |

---

### ✅ Example
```python
Input:  
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output: 
[null,null,null,null,-3,null,0,-2]
