class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = nums.length + 1;
        int sum = 0;
        int i = 0, j = 0;
        while (j <= nums.length - 1) {
            sum += nums[j];
            while (sum >= target) {
                int s = j - i + 1;
                if (size > s)
                    size = s;
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return size < nums.length + 1 ? size : 0;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)