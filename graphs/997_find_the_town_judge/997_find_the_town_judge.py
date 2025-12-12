"""
LeetCode 997. Find the Town Judge
Link: https://leetcode.com/problems/find-the-town-judge/
Difficulty: Easy
Primary: Graph
Tags: [graph, indegree/outdegree, trust-graph, counting]
Solved: 2025-11-14
"""

from typing import List

class Solution:

    # --- Approach 1: Degree Counting ---
    # Time: O(n), Space: O(n) 
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        count = [0] * (n + 1)
        for t in trust:
            count[t[0]] -= 1
            count[t[1]] += 1
        
        for i in range(1, n + 1):
            if count[i] == n - 1:
                return i
        return -1
    

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()

    n = 3
    trust = [[1, 3], [2, 3]]
    print(solution.findJudge(n, trust))  # Output: 3