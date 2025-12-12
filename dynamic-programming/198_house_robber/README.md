# 198. House Robber

**Link:** [LeetCode 70 - Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)  
**Difficulty:** Medium
**Primary Topic:** Dynamic Programming
**Tags:** [dp, array, optimization, state-transition]  
**Languages:** Python, Java  
**Solved:** 2025-11-15

---

### 🧩 Problem Summary
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

---

### 🧠 Approaches

#### Approach 1: Recursion
- Depth first search
- **Time Complexity:** O(2ⁿ)  
- **Space Complexity:** O(n) 

#### Approach 2: Dynamic Programming - Top-Down
- DFS with memoization.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

#### Approach 3-1: Dynamic Programming - Bottom-Up
- Solve subproblems from the bottom step by step.
- **Time Complexity:** O(n) 
- **Space Complexity:** O(n)

#### Approach 3-1: Dynamic Programming - Bottom-Up (Space Optimized)
- Use variable to store for things only need, not all the process. 
- **Time Complexity:** O(n) 
- **Space Complexity:** O(1)

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`198_house_robber.py`](./198_house_robber.py) |
| Java | [`198_house_robber.java`](./198_house_robber.java) |

---

### ✅ Example
```python
Input: nums = [1, 2, 3, 1]
Output: 4
