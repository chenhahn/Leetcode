class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        backtracking(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    
    private void backtracking(List<List<Integer>> list, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            list.add(new ArrayList(temp));
            return;
        }
        
        for (int i = start; i <= n - k + 1; i++) {
            temp.add(i);
            backtracking(list, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }
}

// Time complexity: O(k*C(n,k))
// Space complexity: O(k)