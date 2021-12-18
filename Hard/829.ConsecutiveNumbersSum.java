class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int k = 1; (k * k - k) / 2 < n; k++) {
            if ((n - k * (k - 1) / 2) % k == 0) {
                count++;
            }
        }
        return count;
    }
}

/*
	m + (m + 1) + (m + 2) + ... + (m + k - 1) = n
	m * k + ((1 + k - 1)(k - 1)) / 2 = n
	km = n - k(k - 1)/2
	Since m is an integer, n - k(k - 1)/2 mod k == 0
	
	mk is greater than 0, than n - k(k - 1)/2 > 0, k(k - 1)/2 < n
	
	k ~ sqrt(n)
	time complexity: O(n^1/2)
*/