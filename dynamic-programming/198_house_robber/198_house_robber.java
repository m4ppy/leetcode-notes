/* 
LeetCode 198. House Robber
Link: https://leetcode.com/problems/house-robber/
Difficulty: Medium
Primary: Dynamic Programming
Tags: [dp, array, optimization, state-transition]
Solved: 2025-11-15
*/

import java.util.Arrays;

class Solution {

    // --- Approach 1: Recursion ---
    /// Time: O(2ⁿ), Space: O(n)
    public int rob(int[] nums) {
        return dfs1(0, nums);
    }

    private int dfs1(int i, int[] nums) {
        if (i >= nums.length) return 0;

        return Math.max(nums[i] + dfs1(i + 2, nums), dfs1(i + 1, nums));
    }


    // --- Approach 2: Dynamic Programming - Top-Down (backward) ---
    /// Time: O(n), Space: O(n)
    int[] cache;

    public int rob_topDown(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(0, nums);
    }

    private int dfs(int i, int[] nums) {
        if (i >= nums.length) return 0;
        if (cache[i] != -1) return cache[i];

        cache[i] = Math.max(nums[i] + dfs(i + 2, nums), dfs(i + 1, nums));
        return cache[i]; 
    }


    // --- Approach 3-1: Dynamic Programming - Bottom-Up ---
    /// Time: O(n), Space: O(n)
    public int rob_bottomUp(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }


    // --- Approach 3-2: Dynamic Programming - Bottom-Up (space optimized) ---
    /// Time: O(n), Space: O(1)
    public int rob_bottomUpOptimized(int[] nums) {
        int dp1 = 0, dp2 = 0;
        int temp;

        for (int num : nums) {
            temp = dp2;
            dp2 = Math.max(num + dp1, dp2);
            dp1 = temp;    
        }

        return dp2;
    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(sol.rob_bottomUpOptimized(nums1));  // Output: 4
    }
}
