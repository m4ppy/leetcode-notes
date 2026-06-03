"""
LeetCode 75. Sort Colors
Link: https://leetcode.com/problems/sort-colors/
Difficulty: Medium
Primary: Array
Tags: [array, two-pointers, sorting]
Solved: 2025-10-13
"""

from typing import List

class Solution:

    # --- Approach 1: Counting Sort ---
    # Time: O(n), Space: O(1)
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count = [0] * 3
        for n in nums:
            count[n] += 1
    
        
        i = 0
        for n, cnt in enumerate(count):
            while cnt > 0:
                nums[i] = n
                i += 1
                cnt -= 1



    # --- Approach 2: Two Pointers ---
    # Time: O(n), Space: O(1)
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, r = 0, len(nums) - 1
        i = 0

        def swap(i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

        while i <= r:
            if nums[i] == 0:
                swap(i, l)
                l += 1
            elif nums[i] == 2:
                swap(i, r)
                r -= 1
                i -= 1
            i += 1


# --- Example Test ---
if __name__ == "__main__":
    s = Solution()
    nums = [2, 0, 2, 1, 1, 0]
    s.sortColors(nums)
    print(nums)