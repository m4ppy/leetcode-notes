// Approach 1: Counting Sort
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int i = 0;
        for (int n = 0; n < count.length; n++) {
            int cnt = count[n];
            while (cnt > 0) {
                nums[i] = n;
                cnt--;
                i++;
            }
        }
    }
}

// Approach 2: Two Pointers
// Time complexity: O(n) 
// Space complexity: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
            } 
            else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
