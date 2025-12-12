# 70. Climbing Stairs

**Link:** [LeetCode 70 - Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)  
**Difficulty:** Easy
**Primary Topic:** Dynamic Programming
**Tags:** [dp, memoization, tabulation, fibonacci]  
**Languages:** Python, Java  
**Solved:** 2025-11-15

---

### 🧩 Problem Summary
You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.

Return the number of distinct ways to climb to the top of the staircase.

---

### 🧠 Approaches

#### Approach 1: Recursion
- Adjust Fibonacci sequence.
- **Time Complexity:** O(2ⁿ)  
- **Space Complexity:** O(n) 

#### Approach 2: Dynamic Programming - Top-Down
- 
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

#### Approach 3-1: Dynamic Programming - Bottom-Up
- 
- **Time Complexity:** O(n) 
- **Space Complexity:** O(n)

#### Approach 3-1: Dynamic Programming - Bottom-Up (Space Optimized)
- Use variable to store things to only need, not all the process. 
- **Time Complexity:** O(n) 
- **Space Complexity:** O(1)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`70_climbing_stairs.py`](./70_climbing_stairs.py) |
| Java | [`70_climbing_stairs.java`](./70_climbing_stairs.java) |

---

### ✅ Example
```python
Input: n = 4
Output: 5
