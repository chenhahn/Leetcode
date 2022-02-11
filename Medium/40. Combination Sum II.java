class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain < 0) 
            return;
        
        if (remain == 0) {
            result.add(new ArrayList(temp));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtrack(result, temp, candidates, remain - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

// Time complexity: O(2^N)  suppose each number is unique, each number is either included or excluded in a combination; sorting also takes up to O(NlogN).
// Space complexity: O(N)   recursion stack will pile up to O(N) space.