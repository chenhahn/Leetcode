class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return List.of();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                    
                int k = j + 1, l = nums.length - 1;
                while(k < l){
                    if(k > j + 1 && nums[k] == nums[k - 1]){
                        k++;
                        continue;
                    }
                    if(l < nums.length - 1 && nums[l] == nums[l + 1]){
                        l--; 
                        continue;
                    } 
                    
                    if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                        result.add(List.of(nums[i], nums[j], nums[k++], nums[l]));
                    }else if(nums[i] + nums[j] + nums[k] + nums[l] < target){
                        k++;
                    }else{
                        l--;
                    }                     
                }
            }
        }
        return result;
    }
}