"""
LeetCode 215. Kth Largest Element in an Array
Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
Difficulty: Medium
Primary: Heap
Tags: [heap, priority-queue, quickselect, sorting]
Solved: 2025-11-13
"""

from typing import List, Optional
import heapq

class Solution:

    # --- Approach 1: Sorting ---
    # Time: O(n log n), Space: O(n) 
    def findKthLargest_sorting(self, nums: List[int], k: int) -> int:
        return sorted(nums)[len(nums) - k] 
    
    # --- Approach 2: Heap ---
    # Time: O(k log n), Space: O(k)
    def findKthLargest_heap(self, nums, k):
        return heapq.nlargest(k, nums)[-1]
    
    # --- Approach 3: Quick Select ---
    # Time: average O(n) worst O(n²), Space: O(n)
    def findKthLargest_quick_select(self, nums: List[int], k: int) -> int:
        k = len(nums) - k

        def quickSelect(l, r):
            pivot, p = nums[r], l
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[i], nums[p] = nums[p], nums[i]
                    p += 1
            nums[r], nums[p] = nums[p], nums[r]

            if p > k:
                return quickSelect(l, p - 1)
            elif p < k:
                return quickSelect(p + 1, r)
            else:
                return nums[p]
        
        return quickSelect(0, len(nums) - 1)

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()

    nums = [3,2,1,5,6,4]
    k = 2
    assert solution.findKthLargest_sorting(nums, k) == 5