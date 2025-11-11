// Approach 1: Brute Force
// Time complexity: O(n²) 
// Space complexity: O(1)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res += 1;
                }
            }
        }
        return res;
    }
}

// Approach 2: Prefix + Hash Map
// Time complexity: O(n) 
// Space complexity: O(n) for hash map

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        int res = 0, curSum = 0;
        
        for (int n : nums) {
            curSum += n;
            int diff = curSum - k;

            res += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(curSum, 1 + prefixSums.getOrDefault(curSum, 0));
        }
        
        return res;
    }
}
