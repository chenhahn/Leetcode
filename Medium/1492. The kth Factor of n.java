class Solution {
    public int kthFactor(int n, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int num = 1;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (num == k) {
                    return i;
                }
                map.put(num, i);
                num++;
            }
        }
        num -= 1;
        int j = map.get(num) * map.get(num) == n ? num - (k - num) : num - (k - num) + 1;
        if (j >= 1)
            return n / map.get(j);
        return -1;
    }
}

// Time complexity: O(sqrt n)
// Space complexity: O(sqrt n)