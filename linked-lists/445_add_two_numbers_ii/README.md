# 1. Two Sum

**Link:** [LeetCode 445 - Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)  
**Difficulty:** Medium
**Primary Topic:** Linked List
**Tags:** [linked-list, stack, math, simulation]  
**Languages:** Python, Java  
**Solved:** 2025-11-12

---

### 🧩 Problem Summary
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

---

### 🧠 Approaches

#### Approach 1: Reverse List
- Reverse the lists and then caculate the sum.
- Return new linked list with caculated sum.
- **Time Complexity:** O(m + n)  
- **Space Complexity:** O(max(m, n)) 

#### Approach 2: Stack
- Store calculated sum to stack and build new linked list with it.
- **Time Complexity:** O(m + n)  
- **Space Complexity:** O(m + n)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`445_add_two_numbers_ii.py`](./445_add_two_numbers_ii.py) |
| Java | [`445_add_two_numbers_ii.java`](./445_add_two_numbers_ii.java) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
