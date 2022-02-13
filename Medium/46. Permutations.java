class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        backtrack(nums, 0, result, curList);
        return result;
    }
    
    private void backtrack(int[] nums, int pos, List<List<Integer>> result, List<Integer> curList) {
        int n = nums.length;
        if (pos == n) {
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = pos; i < n; i++) {
            curList.add(nums[i]);
            swap(nums, pos, i);
            backtrack(nums, pos+1, result, curList);
            curList.remove(curList.size() - 1);
            swap(nums, pos, i);
        }
        
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }
}

// Time complexity: O(n*n!)
// Space complexity: O(n*n!)
