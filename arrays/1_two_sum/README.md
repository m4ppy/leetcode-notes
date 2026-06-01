# 1. Two Sum

**Link:** [LeetCode 1 – Two Sum](https://leetcode.com/problems/two-sum/)  
**Difficulty:** Easy  
**Primary Topic:** Hashmaps  
**Tags:** [array, hashmap, prefix-sum]  
**Languages:** Python, Java, C
**Solved:** 2025-10-01  

---

### 🧩 Problem Summary
Given an array of integers `nums` and an integer `target`, return indices of the two numbers that add up to `target`.

---

### 🧠 Approaches

#### Approach 1: Brute Force
- Check every possible pair of numbers to find two that add up to the target.
- **Time Complexity:** O(n²)  
- **Space Complexity:** O(1)

#### Approach 2: Hash Map (Optimal)
- Use a hash map to store numbers and their indices.
- For each number, check if its complement (target - num) already exists.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`1_two_sum.py`](./1_two_sum.py) |
| Java | [`1_two_sum.java`](./1_two_sum.java) |
| C | [`1_two_sum.c`](./1_two_sum.c) |

---

### ✅ Example
```python
Input: nums = [2,7,11,15], target = 9  
Output: [0,1]
