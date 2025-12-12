# 1. Two Sum

**Link:** [LeetCode 215 - Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)  
**Difficulty:** Medium
**Primary Topic:** Heap
**Tags:** [heap, priority-queue, quickselect, sorting]  
**Languages:** Python, Java  
**Solved:** 2025-11-13

---

### 🧩 Problem Summary
Given an integer array nums and an integer k, return the kth largest element in the array.

---

### 🧠 Approaches

#### Approach 1: Sorting
- Sort the array and return kth largest element.
- **Time Complexity:** O(n log n)  
- **Space Complexity:** O(n) 

#### Approach 2: Heap
- Use heap to extract kth largest element.
- **Time Complexity:** O(k log n)  
- **Space Complexity:** O(k)

#### Approach 3: Quick Select
- 
- **Time Complexity:** average O(n) worst O(n²) 
- **Space Complexity:** O(n)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`215_kth_largest_element_in_an_array.py`](./215_kth_largest_element_in_an_array.py) |
| Java | [`215_kth_largest_element_in_an_array.java`](./215_kth_largest_element_in_an_array.java) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
