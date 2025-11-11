"""
LeetCode 1. Two Sum
Link: https://leetcode.com/problems/two-sum/
Difficulty: Easy
Primary: hashmaps
Tags: [array, hashmap, prefix-sum]
Solved: 2025-11-11
"""

from typing import List

class Solution:
    
    # --- Approach 1: Brute Force ---
    # Time: O(n²), Space: O(1)
    def two_sum_bruteforce(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []


    # --- Approach 2: Hash Map (Optimal) ---
    # Time: O(n), Space: O(n)
    def two_sum_hashmap(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i, num in enumerate(nums):
            complement = target - num
            if complement in seen:
                return [seen[complement], i]
            seen[num] = i
        return []


# --- Example Test ---
if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    s = Solution()
    print(s.two_sum_hashmap(nums, target))  # [0, 1]