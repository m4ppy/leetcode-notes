// Approach 1: Brute Force
// Time complexity: O(n²)
// Space complexity: O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return int[]{};
    }
}

// Approach 2: Hash Map
// Time complexity: O(n) because it's one pass
// Space complexity: O(n) for HashMap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[]{hashMap.get(nums[i]), i};
            }
            hashMap.put(target - nums[i], i);
        }

        return new int[]{};
    }
}
