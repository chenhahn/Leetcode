class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] toAdd = newInterval;
        
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < toAdd[0]) {
                result.add(intervals[i]);
            }
                        
            if (intervals[i][0] > toAdd[1]) {
                result.add(toAdd);
                toAdd = intervals[i];
            }
            
            if (intervals[i][1] >= toAdd[0]) {
                toAdd = new int[] {Math.min(intervals[i][0], toAdd[0]), Math.max(intervals[i][1], toAdd[1])};
            }
        }
        
        result.add(toAdd);
        
        return result.toArray(new int[result.size()][2]);
    }
}

// Time complexity: O(n)
// Space complexity: O(n)