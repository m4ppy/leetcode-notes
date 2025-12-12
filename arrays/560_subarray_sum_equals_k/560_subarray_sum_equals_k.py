# Approach 1: Brute Force
# Time complexity: O(n²) 
# Space complexity: O(1)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        for i in range(len(nums)):
            curSum = 0
            for j in range(i, len(nums)):
                curSum += nums[j]
                if curSum == k:
                    res += 1

        return res

# Approach 2: Prefix + Hash Map
# Time complexity: O(n) 
# Space complexity: O(n) for hash map

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixSums = {0 : 1}
        res, curSum = 0, 0

        for n in nums:
            curSum += n
            diff = curSum - k

            if diff in prefixSums:
                res += prefixSums[diff]
            prefixSums[curSum] = 1 + prefixSums.get(curSum, 0)

        return res
