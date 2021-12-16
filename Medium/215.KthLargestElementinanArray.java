class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, index);
    }
    
    public int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right], pointer = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, pointer, i);
                pointer++;
            }
        }
        swap(nums, pointer, right);
        if (pointer > k) return quickSelect(nums, left, pointer - 1, k);
        if (pointer < k) return quickSelect(nums, pointer + 1, right, k);
        return nums[pointer];
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}