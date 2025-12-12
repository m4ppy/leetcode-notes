/*
LeetCode 215. Kth Largest Element in an Array
Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
Difficulty: Medium
Primary: Heap
Tags: [heap, priority-queue, quickselect, sorting]
Solved: 2025-11-13
*/

import java.util.*;

class Solution {

    // --- Approach 1: Sorting ---
    // Time: O(n log n), Space: O(n)
    public int findKthLargest_sorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // --- Approach 2: Heap ---
    // Time: O(k log n), Space: O(k)
    public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    // --- Approach 3: Quick Select ---
    // Time: average O(n) worst O(n²), Space: O(n)
    public int findKthLargest_quickSelect(int[] nums, int k) {
        k = nums.length - k;

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[r];
        int p = l;

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        int temp = nums[r];
        nums[r] = nums[p];
        nums[p] = temp;

        if (p > k) {
            return quickSelect(nums, l, p - 1, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, r, k);
        } else {
            return nums[p];
        }
    }

    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(sol.findKthLargest_quickSelect(nums, k)); // Output: 5
    }
    
}