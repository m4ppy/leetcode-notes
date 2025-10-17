# algorithm must runs in O(n) time -> only Hash Set solution is right.

# Approach 1: Brute Force
# Time complexity: O(n²) because we use two nested loops to traverse the list.
# Space complexity: O(n) as no extra space is used.

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        longest = 0
        hashSet = set(nums)

        for num in nums:
            length, curr = 0, num
            while curr in hashSet:
                length += 1
                curr += 1
            longest = max(length, longest)
        return longest

# Approach 2: Sorting
# Time complexity: O(n log n)
# Space complexity: O(n) or O(1) depending on sorting algorithm.

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        res = 0
        nums.sort()

        curr, streak = nums[0], 0
        i = 0
        while i < len(nums):
            if curr != nums[i]:
                curr = nums[i]
                streak = 0
            while i < len(nums) and nums[i] == curr:
                i += 1
            streak += 1
            curr += 1
            res = max(res, streak)
        return res

# Approach 3: Hash Set
# Time complexity: O(n) 
# Space complexity: O(n) 

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hashSet = set()
        longest = 0

        for n in nums:
            if n - 1 not in nums and n not in hashSet:
                hashSet.add(n)
                length = 1
                while n + length in nums:
                    length += 1
                longest = max(length, longest)
              
        return longest
