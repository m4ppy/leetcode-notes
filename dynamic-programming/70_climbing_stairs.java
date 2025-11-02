// Approach 1: Recursion
// Time complexity: O(2ⁿ)
// Space complexity: O(n) 

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// Approach 2-1: Dynamic Programming - Top-Down (backward)
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }
        return dfs(n);
    }

    public int dfs(int i) {
        if (i <= 2) return i;
        if (cache[i] != -1) return cache[i];
        return cache[i] = dfs(i - 1) + dfs(i - 2);
    }
}

// Approach 2-2: Dynamic Programming - Top-Down (forward)
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(0, n);
    }

    public int dfs(int i, int len) {
        if (i >= len) return i == len ? 1 : 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = dfs(i + 1, len) + dfs(i + 2, len);
    }
}

// Approach 3-1: Dynamic Programming - Bottom-Up
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Approach 3-2: Dynamic Programming - Bottom-Up (space optimized)
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int climbStairs(int n) {
        int prev1 = 1, prev2 = 1;
        for (int i = 1; i < n; i++) {
            int temp = prev1;
            prev1 = prev1 + prev2;
            prev2 = temp;
        }
        return prev1;
    }
}
