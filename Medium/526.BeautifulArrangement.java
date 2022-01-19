class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        permutation(arr, 0, n-1);
        return count;
    }
    
    private void permutation(int[] a, int m, int n) {
        if (m == n && isDivisible(m + 1, a[m])) {
            count++;
        }
        
        for (int i = m; i <= n; i++) {
            swap(a, m, i);
            if (isDivisible(m + 1, a[m])) {
                permutation(a, m+1, n);
            }
            swap(a, m, i);
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private boolean isDivisible(int index, int value) {
        return index % value == 0 || value % index == 0;
    }
}

// Time complexity: O(k)	-> number of valid permutation
// Space complexity: O(n)	-> depth of recursion tree can go uptp n, and the size of array is n