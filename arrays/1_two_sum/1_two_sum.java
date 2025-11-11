/*
LeetCode 1. Two Sum
Link: https://leetcode.com/problems/two-sum/
Difficulty: Easy
Primary: hashmaps
Tags: [array, hashmap, prefix-sum]
Solved: 2025-11-11
*/

import java.util.*;

class Solution {

    // --- Approach 1: Brute Force ---
    // Time: O(n²), Space: O(1)
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    // --- Approach 2: Hash Map (Optimal) ---
    // Time: O(n), Space: O(n)
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(sol.twoSumHashMap(nums, target)));    // [0, 1]
    }
}