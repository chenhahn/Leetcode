class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        
        int max = 0;
        
        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curCount = 1;
                
                while (numSet.contains(curNum + 1)) {
                    curNum++;
                    curCount++;
                }
                
                if (max < curCount) 
                    max = curCount;
            }
        }
        
        return max;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)