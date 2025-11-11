// algorithm must runs in O(n) time -> only Hash Set solution is right.

// Approach 1: Brute Force
// Time complexity: O(n²)
// Space complexity: O(n) for hashSet

public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        for (int num : nums) {
            int streak = 0, curr = num;
            while (store.contains(curr)) {
                streak++;
                curr++;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}

// Approach 2: Sorting
// Time complexity: O(n log n)
// Space complexity: O(n) or O(1) depending on sorting algorithm.

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}

// Approach 3: Hash Set
// Time complexity: O(n) 
// Space complexity: O(n) for hashSet

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        int longest = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int length = 1;
                while (numSet.contains(n + length)) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
