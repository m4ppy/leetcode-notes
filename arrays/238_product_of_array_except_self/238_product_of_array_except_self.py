# Approach 1: Brute Force
# Time complexity: O(n²)
# Space complexity: O(n) for output or O(1).

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(len(nums)):
            prod = 1
            for j in range(len(nums)):
                if j == i:
                    continue
                prod *= nums[j]
            res.append(prod)
        return res

# Approach 2: Prefix & Suffix
# Time complexity: O(n) traverse list twice seperately.
# Space complexity: O(n) for output or O(1).

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [] #1 1 2 8
        total = 1
        for n in nums:
            prefix.append(total)
            total *= n
        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
            prefix[i] *= postfix 
            postfix *= nums[i]
        return prefix
