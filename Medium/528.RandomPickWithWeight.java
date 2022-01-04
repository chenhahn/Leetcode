class Solution {
    Random random;
    int[] sums;

    public Solution(int[] w) {
        random = new Random();
        sums = new int[w.length];
        sums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sums[i] = sums[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int len = sums.length;
        int randNum = random.nextInt(sums[len - 1]) + 1;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sums[mid] == randNum) {
                return mid;
            } else if (sums[mid] < randNum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

// Time complexity: O(N + logN) -> O(N)
// Space complexity: O(N)