# 75. Sort Colors

**Link:** [LeetCode 75 – Sort Colors](https://leetcode.com/problems/sort-colors/)  
**Difficulty:** Medium  
**Primary Topic:** Array  
**Tags:** [array, two-pointers, sorting]  
**Languages:** Python, Java  
**Solved:** 2025-10-13  

---

### 🧩 Problem Summary

Given an array containing only `0`, `1`, and `2`, sort the array in-place so that all `0`s come first, followed by all `1`s, then all `2`s.

The solution should modify the original array without using a built-in sort function.

---

### 🧠 Approaches

#### Approach 1: Counting Sort
- Count the number of `0`s, `1`s, and `2`s.
- Overwrite the array using the recorded counts.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

#### Approach 2: Two Pointers
- Use three pointers (`left`, `current`, `right`) to partition the array.
- Place `0`s on the left, `2`s on the right, and leave `1`s in the middle.
- Also known as the **Dutch National Flag Algorithm**.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

### 🚀 Approaches Implemented

| Language | File |
|-----------|------|
| Python | [`75_sort_colors.py`](./75_sort_colors.py) |
| Java | [`75_sort_colors.java`](./75_sort_colors.java) |

---

### ✅ Example

```python
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]