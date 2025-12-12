/* 
LeetCode 70. Climbing Stairs
Link: https://leetcode.com/problems/climbing-stairs/
Difficulty: Easy
Primary: Dynamic Programming
Tags: [dp, memoization, tabulation, fibonacci]
Solved: 2025-11-15
*/


class Solution {

    // --- Approach 1: Recursion ---
    /// Time: O(2ⁿ), Space: O(n)
    public int climbStairs_recursion(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs_recursion(n - 1) + climbStairs_recursion(n - 2);
    }


    // --- 2-1: Dynamic Programming - Top-Down (backward) ---
    /// Time: O(n), Space: O(n)
    int[] cache1;

    public int climbStairs_topDownBackward(int n) {
        cache1 = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache1[i] = -1;
        }
        return dfs(n);
    }

    public int dfs(int i) {
        if (i <= 2) return i;
        if (cache1[i] != -1) return cache1[i];
        return cache1[i] = dfs(i - 1) + dfs(i - 2);
    }


    // --- 2-2: Dynamic Programming - Top-Down (forward) ---
    /// Time: O(n), Space: O(n)
    //int[] cache;
    int[] cache2;

    public int climbStairs_topDownForward(int n) {
        cache2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cache2[i] = -1;
        }
        return dfs(0, n);
    }

    public int dfs(int i, int len) {
        if (i >= len) return i == len ? 1 : 0;
        if (cache2[i] != -1) return cache2[i];
        return cache2[i] = dfs(i + 1, len) + dfs(i + 2, len);
    }


    // --- 3-1: Dynamic Programming - Bottom-Up ---
    /// Time: O(n), Space: O(n)
    public int climbStairs_bottomUp(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    // --- 3-2: Dynamic Programming - Bottom-Up (space optimized) ---
    /// Time: O(n), Space: O(1)
    public int climbStairs_bottomUpOptimized(int n) {
        int prev1 = 1, prev2 = 1;
        for (int i = 1; i < n; i++) {
            int temp = prev1;
            prev1 = prev1 + prev2;
            prev2 = temp;
        }
        return prev1;
    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 4;
        System.out.println(sol.climbStairs_bottomUpOptimized(n1)); // Expected: 5
    }
}
