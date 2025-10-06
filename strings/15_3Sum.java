// Approach 2: Two Pointers
// Time complexity: O(n²) sort the array and use two pointers for each element. 
// Space complexity: O(1) or O(n) depending on sort algorithm.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int curSum = nums[i] + nums[l] + nums[r];

                if (curSum < 0) {
                    l++;
                } else if (curSum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
                    
    
            }
        }
        return res;
    }
}
