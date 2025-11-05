# Approach 1: Brute Force
# Time complexity: O(n²)  
# Space complexity: O(1) 

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = nums[0]

        for i in range(len(nums)):
            sum = 0
            for j in range(i, len(nums)):
                sum += nums[j]
                res = max(res, sum)
        
        return res

# Approach 2: Kadane Algorithm
# Time complexity: O(n)  
# Space complexity: O(1) 

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = nums[0]
        sum = 0 
        for n in nums:
            sum = max(sum, 0)
            sum += n
            res = max(res, sum)
        
        return res
