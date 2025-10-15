// Approach 1: Brute Force
// Time complexity: O(n²)
// Space complexity: O(n) for output or O(1).

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }
}  

// Approach 2: Prefix & Suffix
// Time complexity: O(n) traverse list twice seperately.
// Space complexity: O(n) for output or O(1).

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}  
