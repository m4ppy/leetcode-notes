"""
LeetCode 198. House Robber
Link: https://leetcode.com/problems/house-robber/
Difficulty: Medium
Primary: Dynamic Programming
Tags: [dp, array, optimization, state-transition]
Solved: 2025-11-15
"""

from typing import List

class Solution:

    # --- Approach 1: Recursion ---
    # Time: O(2ⁿ), Space: O(n) 
    def rob_recursion(self, nums: List[int]) -> int:
        def dfs(i):
            if i >= len(nums):
                return 0
            return max(nums[i] + dfs(i + 2), dfs(i + 1))

        return dfs(0)


    # --- Approach 2: Dynamic Programming - Top-Down ---
    # Time: O(n), Space: O(n)
    def rob_top_down(self, nums: List[int]) -> int:
        memo = [-1] * len(nums)

        def dfs(i):
            if i >= len(nums):
                return 0
            if memo[i] != -1:
                return memo[i]
            memo[i] = max(nums[i] + dfs(i + 2), dfs(i + 1))
            return memo[i]

        return dfs(0)


    # --- Approach 3-1: Dynamic Programming - Bottom-Up ---
    # Time: O(n), Space: O(n)
    def rob_bottom_up(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return nums[0]
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])

        return dp[-1]
    

    # --- Approach 3-2: Dynamic Programming - Bottom-Up (space optimized) ---
    # Time: O(n), Space: O(1)
    def rob_bottom_up_space_optimized(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        dp1, dp2 = nums[0], max(nums[0], nums[1])
        for i in range(2, len(nums)):
            temp = dp2
            dp2 = max(nums[i] + dp1, dp2)
            dp1 = temp
        
        return dp2

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()

    # Example 1
    nums1 = [1, 2, 3, 1]
    print(solution.rob_bottom_up_optimized(nums1))  # Output: 4