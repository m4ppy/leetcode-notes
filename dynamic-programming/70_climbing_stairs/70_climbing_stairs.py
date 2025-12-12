"""
LeetCode 70. Climbing Stairs
Link: https://leetcode.com/problems/climbing-stairs/
Difficulty: Easy
Primary: Dynamic Programming
Tags: [dp, memoization, tabulation, fibonacci]
Solved: 2025-11-15
"""

from typing import List

class Solution:

    # --- Approach 1: Recursion ---
    # Time: O(2ⁿ), Space: O(n) 
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        return self.climbStairs(n - 1) + self.climbStairs(n - 2)


    # --- Approach 2-1: Dynamic Programming - Top-Down (backward) ---
    # Time: O(n), Space: O(n)
    def climbStairs(self, n: int) -> int:
        def dfs(i):
            if i <= 2:
                return i

            if cache[i] != -1:
                return cache[i]
            
            cache[i] = dfs(i - 1) + dfs(i - 2)
            return cache[i]

        cache = [-1] * (n + 1)
        return dfs(n)


    # --- Approach 2-2: Dynamic Programming - Top-Down (forward) ---
    # Time: O(n), Space: O(n)
    def climbStairs(self, n: int) -> int:
        def dfs(i):
            if i >= n:
                return i == n

            if cache[i] != -1:
                return cache[i]
            
            cache[i] = dfs(i + 1) + dfs(i + 2)
            return cache[i]

        cache = [-1] * n
        return dfs(0)


    # --- Approach 3-1: Dynamic Programming - Bottom-Up ---
    # Time: O(n), Space: O(n)
    def climbStairs(self, n: int) -> int:
        dp = [-1] * n
        dp[0], dp[1] = 1, 2
        for i in range(2, n):
            dp[i] = dp[i - 1] + dp[i -2]
        
        return dp[n - 1]
    

    # --- Approach 3-2: Dynamic Programming - Bottom-Up (space optimized) ---
    # Time: O(n), Space: O(1)
    def climbStairs(self, n: int) -> int:
        prev1, prev2 = 1, 1
        
        for i in range(n - 1):
            temp = prev1
            prev1 = prev1 + prev2
            prev2 = temp
        
        return prev1

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()

    n1 = 4
    print(solution.climbStairs(n1))  # Expected: 5