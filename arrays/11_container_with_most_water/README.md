# 1. Two Sum

**Link:** [LeetCode 11 – Container With Most Water](https://leetcode.com/problems/two-sum/)  
**Difficulty:** Easy  
**Primary Topic:** Hashmaps  
**Tags:** [array, hashmap, prefix-sum]  
**Languages:** Python, Java  
**Solved:** 2025-11-03  

---

### 🧩 Problem Summary
Given an array of integers `nums` and an integer `target`, return indices of the two numbers that add up to `target`.

---

### 🧠 Approaches

#### Approach 1: Brute Force
- Check every possible pair of numbers to find two that add up to the target.
- **Time Complexity:** O(n²) 
- **Space Complexity:** O(1)

#### Approach 2: Two Pointers
- Use a hash map to store numbers and their indices.
- For each number, check if its complement (target - num) already exists.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

### 🚀 Approaches Implemented
| Approach | Time | Space | File |
|-----------|------|--------|------|
| Brute Force | O(n²) | O(1) | [`11_container_with_most_water.py`](./11_container_with_most_water.py) |
| Two Pointers | O(n) | O(1) | [`11_container_with_most_water.java`](./11_container_with_most_water.java) |

---

### ✅ Example
```python
Input: nums = [2,7,11,15], target = 9  
Output: [0,1]
