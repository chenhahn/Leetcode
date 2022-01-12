class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) 
            return nums.length;
        
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;   
            }else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            } 
        }
        return left;
    }
}