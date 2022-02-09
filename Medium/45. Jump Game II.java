class Solution {
    public int jump(int[] nums) {
        int jumps = 0, preFarthest = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (curFarthest >= nums.length - 1)
                return jumps + 1;
            if (i == preFarthest) {
                jumps++;
                preFarthest = curFarthest;
            }
        }
        return jumps;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)