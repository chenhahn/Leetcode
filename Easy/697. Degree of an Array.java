class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (left.get(num) == null) left.put(num, i);
            right.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int result = nums.length;
        int degree = Collections.max(count.values());
        for (int num: count.keySet()) {
            if (count.get(num) == degree)
                result = Math.min(result, right.get(num) - left.get(num) + 1);
        }
        
        return result;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)