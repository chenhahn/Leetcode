class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int total = 0;
        int remainSize = truckSize;
        // Arrays.sort(boxTypes, new Comparator<int[]>() {
        //     public int compare(final int[] entry1, final int[] entry2) {
        //         final Integer num1 = entry1[1];
        //         final Integer num2 = entry2[1];
        //         return num1.compareTo(num2);
        //     }
        // });
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(a[1], b[1]));
        
        for (int i = boxTypes.length - 1; i >= 0; i--){
            if (remainSize > boxTypes[i][0]) {
                remainSize -= boxTypes[i][0];
                total += boxTypes[i][0] * boxTypes[i][1];
            } else {
                total += remainSize * boxTypes[i][1];
                return total;
            }
        }
        return total;
    }
}

// Time complexity: O(NlogN)
// Space complexity: O(N)