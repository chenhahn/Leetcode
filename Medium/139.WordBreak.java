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

// Recursion with memoization
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
           return true; 
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
/*	
Time complexity : O(n^3). 

take substring computation into account, it would finally be 1 + (1 + 2) + (1 + 2 +3) .... = n(n + 1)(n + 2) / 6
d (c, cd) (b, bc, bcd), (a, ab, abc, abcd)
s = "abcd" and wordDict = ["a", "b", "c", "bc", "ab", "abc"]
 
Space complexity : O(n). The depth of recursion tree can go up to n.
*/

// Dynamic Programming

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
/*	
Time complexity : O(n^3). There are two nested loops, and substring computation at each iteration. Overall that results in O(n^3)
	time complexity.

Space complexity : O(n). Length of p array is n+1.

*/

// Breadth-First-Search
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == true) continue;
            for (int end = start + 1; end <= s.length(); end++) {
                if(wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if(end == s.length()) return true;
                }
            }
            visited[start] = true;
        }
        return false;
    }
}
/*	
Time complexity : O(n^3). 

Space complexity : O(n).

*/