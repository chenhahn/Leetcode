class Solution {
    public boolean canJump(int[] nums) {
        int goalIndex = nums.length - 1;
        
        for (int i = nums.length - 2; i >=0; i--) {
            if (nums[i] >= goalIndex - i) {
                goalIndex = i;
            }
        }
        
        return goalIndex == 0 ? true : false;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)