//Brute Force

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
}

/*	
Time complexity: O(2^n), Given a string of length nn, there are n+1 ways to split it into two parts. At each step, we have a choice: 
to split or not to split. In the worse case, when all choices are to be checked, that results in O(2^n).

For example: s = "abcd" and wordDict = ["a", "b", "c", "bc", "ab", "abc"]

Space complexity: O(n), The depth of the recursion tree can go upto n.

*/