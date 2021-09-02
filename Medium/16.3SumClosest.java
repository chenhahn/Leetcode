class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] +nums[2];
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] +nums[k];
                
                if(sum > target){
                    k--;                   
                }else if(sum < target){
                    j++;
                }else{
                    return target;
                }
                
                if(Math.abs(result - target) > Math.abs(sum - target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}