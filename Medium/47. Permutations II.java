class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, nums, 0);
        return res;
    }
    
    private void permute(List<List<Integer>> list, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                tempList.add(nums[i]);
            }
            list.add(tempList);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (seen.add(nums[i])) {
                swap(nums, start, i);
                permute(list, nums, start + 1);
                swap(nums, start, i); 
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time complexity: O(n*n!)
// Space complexity: O(n*n!)