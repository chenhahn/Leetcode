class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0;
        int finalSurplus = 0;
        int startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            finalSurplus +=  gas[i] - cost[i];
            surplus +=  gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                startIndex = i + 1;
            }
        }
        return finalSurplus < 0 ? -1 : startIndex;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)