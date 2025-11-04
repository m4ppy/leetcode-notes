Brute Force

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        res = 0

        for i in range(len(nums)):
            sum = nums[i]
            for j in range(i + 1, len(nums)):
                sum += nums[j]
                res = max(res, sum)
        
        return res
