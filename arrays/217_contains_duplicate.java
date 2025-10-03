// Approach 2: Hash Set
// Time complexity: O(n²)
// Space complexity: O(1)

class Solution {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Approach 2: Hash Set
// Time complexity: O(n) traverse the list once.
// Space complexity: O(n) for hash set.

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
