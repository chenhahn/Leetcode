/*
    implement the variant of Binary Search O(logn)
    1) If target < nums[left] <= nums[mid], then target is in left hand side of pivot
    2) If target > nums[right] >= nums[mid], then target is in right hand side of pivot
    *pivot is the rotated place of orignal array
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length ==0 ) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
               return mid; 
            } else if (nums[mid] > target) {
                if(nums[left] <= nums[mid] && nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1; 
                }
            } else {
                if(nums[right] >= nums[mid] && nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

