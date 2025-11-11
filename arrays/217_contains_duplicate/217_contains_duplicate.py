# Approach 1: Brute Force
# Time complexity: O(n²) -> leetcode OJ occurs Time Limit Exceeded. we need optimization.
# Space complexity: O(1) as no extra space is used.

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    return True
        return False

# Approach 2: Hash Set
# Time complexity: O(n) traverse the list once.
# Space complexity: O(n) for hash set.

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hashSet = set()
        for n in nums:
            if n in hashSet:
                return True
            hashSet.add(n)
        return False

# Approach 3: Hash Set Length
# Time complexity: O(n) 
# Space complexity: O(n) for hash set.

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) < len(nums)
