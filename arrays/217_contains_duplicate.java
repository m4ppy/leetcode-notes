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
