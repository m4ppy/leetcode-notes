// Approach 1: Brute Force
// Time complexity: O(n²)  
// Space complexity: O(1) 

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}

// Approach 2: Kadane Algorithm
// Time complexity: O(n)  
// Space complexity: O(1) 

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(0, sum);
            sum += nums[i];
            res = Math.max(sum, res);
        }
        return res;
    }
}
