# Approach 1: Brute Force
# Time complexity: O(n³)
# Space complexity: O(m) m is the number of triplets.

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = set()
        nums.sort()
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                for k in range(j + 1, len(nums)):
                    if nums[i] + nums[j] + nums[k] == 0:
                        tmp = [nums[i], nums[j], nums[k]]
                        res.add(tuple(tmp))
        return [list(i) for i in res]

# Approach 2: Hash Map
# Time complexity: O(n²)
# Space complexity: O(n) for hash map.

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        count = defaultdict(int)
        for num in nums:
            count[num] += 1

        res = []
        for i in range(len(nums)):
            count[nums[i]] -= 1
            if i and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, len(nums)):
                count[nums[j]] -= 1
                if j - 1 > i and nums[j] == nums[j - 1]:
                    continue
                target = -(nums[i] + nums[j])
                if count[target] > 0:
                    res.append([nums[i], nums[j], target])

            for j in range(i + 1, len(nums)):
                count[nums[j]] += 1
        return res

# Approach 3: Two Pointers
# Time complexity: O(n²)
# Space complexity: O(n) or O(1) depending on sort algorithm.

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()

        for i, n in enumerate(nums):
            if n>0:
                break
            if i>0 and n == nums[i-1]:
                continue
            left, right = i+1, len(nums)-1
            while left < right:
                Sum1 = n + nums[left] + nums[right]
                if Sum1 > 0:
                    right -= 1
                elif Sum1 < 0:
                    left += 1
                else:
                    result.append([n, nums[left], nums[right]]) 
                    right -= 1
                    left += 1
                    while nums[left] == nums[left - 1] and left < right:
                        left += 1 
        return result
