# Approach 1-1: Brute Force
# Time complexity: O(n²) because we use two nested loops to traverse the list.
# Space complexity: O(1) as no extra space is used.

class Solution:
  def twoSum(self, nums: List[int], target: int) -> List[int]:
    #brute force
    for i in range(len(nums)):
      for j in range(len(nums)):
        if nums[i]+nums[j] == target and i != j:
          return [i, j]
    return []

# Approach 1-2: Improved Brute Force
# Time complexity: O(n²) because we still use two nested loops.
# Space complexity: O(1) as no extra space is used.
# Optimization: The second loop starts from `i+1` to avoid redundant comparisons and eliminate the need to check `i != j`.

class Solution:
  def twoSum(self, nums: List[int], target: int) -> List[int]:
    # Improved(Optimized) brute force
    for i in range(len(nums) - 1):  # Only iterate up to len(nums) - 1
      for j in range(i + 1, len(nums)):  # Start `j` from `i+1` to skip duplicates
        if nums[i] + nums[j] == target:
          return [i, j]
    return []
    
# Approach 2: Hash Map
# Time complexity: O(n) because we traverse the list once.
# Space complexity: O(n) for storing elements in the hash map.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}  # To store value and its index
        for i, num in enumerate(nums):
            complement = target - num
            if complement in num_map:
                return [num_map[complement], i]
            num_map[num] = i
        return []

# Approach 3: Two Pointers (Not Applicable Here)
# Time complexity: O(n log n) for sorting + O(n) for two-pointer traversal.
# Why it doesn't work:
# Two Pointers require the array to be sorted, but sorting changes the indices,
# and this problem explicitly asks for the original indices of the solution.
# Therefore, the Two Pointers technique is not suitable for this problem.
