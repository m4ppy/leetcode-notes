# 1. Two Sum

**Link:** [LeetCode 997 - Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)  
**Difficulty:** Easy
**Primary Topic:** Graph
**Tags:** [graph, indegree/outdegree, trust-graph, counting]  
**Languages:** Python, Java  
**Solved:** 2025-11-14

---

### 🧩 Problem Summary
You are given an array `trust` where `trust[i] = [ai, bi]` representing that the person labeled `ai` trusts the person labeled `bi`. If a trust relationship does not exist in `trust` array, then such a trust relationship does not exist.
Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

---

### 🧠 Approaches

#### Approach 1: In-degree / Out-degree Counting
- Compute each person’s net degree = out-degree(being tursted) – int-degree(give trust).
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n) 

---

### 🚀 Approaches Implemented
| Language | File |
|-----------|------|
| Python | [`997_find_the_town_judge.py`](./997_find_the_town_judge.py) |
| Java | [`997_find_the_town_judge.java`](./997_find_the_town_judge.java) |

---

### ✅ Example
```python
Input: s = "anagram", t = "nagaram"
Output: True
