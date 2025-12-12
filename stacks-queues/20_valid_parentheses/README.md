# 1. Two Sum

**Link:** [LeetCode 20 - Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)  
**Difficulty:** Easy  
**Primary Topic:** Stack
**Tags:** [stack, string, bracket-matching]  
**Languages:** Python, Java  
**Solved:** 2025-11-12

---

### 🧩 Problem Summary
Given a string s containing just the characters `(`, `)`, `{`, `}`, `[` and `]`, determine if the input string is valid.

---

### 🧠 Approaches

#### Approach 1: Brute Force
- Check every possible pair of closed parentheses and remove them.
- String.replace requires extra space. not in-place.
- **Time Complexity:** O(n²)  
- **Space Complexity:** O(n) 

#### Approach 2: Stack
- Use a hashmap that key is close parenthesis and value is open parenthesis.
- Use a stack to store open parenthesis.
- Pop when close parenthesis matches with last open parenthesis in stack. 
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`20_valid_parentheses.py`](./20_valid_parentheses.py) |
| Java | [`20_valid_parentheses.java`](./20_valid_parentheses.java) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
