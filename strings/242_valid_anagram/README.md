# 242. Valid Anagram

**Link:** [LeetCode 242 – Valid Anagram](https://leetcode.com/problems/valid-anagram/)  
**Difficulty:** Easy  
**Primary Topic:** Hashmaps  
**Tags:** [string, hashmap, count]  
**Languages:** Python, Java, C
**Solved:** 2025-11-11 

---

### 🧩 Problem Summary
Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.

---

### 🧠 Approaches

#### Approach 1: Sorting
- Sort both strings and compare them.
- If the sorted strings are identical, they are anagrams.
- **Time Complexity:** O(n log n)  
- **Space Complexity:** O(1) or O(n) depending on the sorting implementation

#### Approach 2: Hash Map
- Count the frequency of each character using a hash map.
- If all character counts match, they are anagrams.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

#### Approach 3: Hash Table (Array)
- Count the frequency of each character using a fixed-size array.
- If all character counts match, they are anagrams.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`242_valid_anagram.py`](./242_valid_anagram.py) |
| Java | [`242_valid_anagram.java`](./242_valid_anagram.java) |
| C | [`242_valid_anagram.c`](./242_valid_anagram.c) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
