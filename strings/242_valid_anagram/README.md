# 1. Two Sum

**Link:** [LeetCode 242 – Valid Anagram](https://leetcode.com/problems/valid-anagram/)  
**Difficulty:** Easy  
**Primary Topic:** Hashmaps  
**Tags:** [string, hashmap, count]  
**Languages:** Python, Java  
**Solved:** 2025-11-11 

---

### 🧩 Problem Summary
Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.

---

### 🧠 Approaches

#### Approach 1: Sorting
- Check every possible pair of numbers to find two that add up to the target.
- **Time Complexity:** O(n²)  
- **Space Complexity:** O(1)

#### Approach 2: Hash Map
- Use a hash map to store numbers and their indices.
- For each number, check if its complement (target - num) already exists.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`242_valid_anagram.py`](./242_valid_anagram.py) |
| Java | [`242_valid_anagram.java`](./242_valid_anagram.java) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
