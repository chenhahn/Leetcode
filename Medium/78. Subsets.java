class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int length = 0; length <= nums.length; length++) {
            backtrack(result, new ArrayList<Integer>(), 0, nums, length);
        }
        return result;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int start, int[] nums, int length) {
        if (tempList.size() == length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, i + 1, nums, length);
            tempList.remove(tempList.size() - 1);
        }
    }
}

// Time complexity: O(N * 2^N)  2^N subsets and each subset at most N elements to be copied into result
// Space complexity: O(N)  space of tempList for storing elements