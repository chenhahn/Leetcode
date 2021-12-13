class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length ==0) return 1;
        int n = nums.length, containOne = 0;
            
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                containOne = 1;
            }else if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        
        if(containOne == 0) return 1;
        
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -1 * nums[index];
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
}
/*
	1.The missing number must be in [1 ... n+1]
	2.Use each number in the array as index, and change corresponding value to negative
	3.Loop over the array again. When we encounter the first non-negative number, then we return (its index + 1), since it means the number which is equal to the index + 1, is not in the array
*/
//Time complexity: O(n), loop over the array 3 times
//Space complexity: O(1) 