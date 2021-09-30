class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int pre = -101;
        for(int i =0; i < nums.length; i++){
            if(nums[i] != pre){
                nums[result] = nums[i];
                result++;
            }
            pre = nums[i];
        }
        return result;
    }
}