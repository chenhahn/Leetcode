// counting sort

class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            if (nums[i] == 1) count1++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            }
            if (i >= count0 && i < count1 + count0) {
                nums[i] = 1;
            }
            if (i >= count1 + count0) {
                nums[i] = 2;
            }
        }
    }
}

// quick partition

class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1, current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 1) {
                current++;
            } else{
                swap(nums, current, right);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)