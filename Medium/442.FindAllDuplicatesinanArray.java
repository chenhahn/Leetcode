class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                lst.add(Math.abs(nums[i]));
            }
        }
        return lst;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)