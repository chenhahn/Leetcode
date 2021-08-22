// DP Approach
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 1;
        int start = 0;
        
        boolean table[][] = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            table[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        for(int k = 3; k <= n; k++){
            for(int i = 0; i < n - k + 1; i++){
                int j = i + k - 1;
                if(table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    table[i][j] = true;
                    
                    if(k > maxLength){
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}

// Expand Around Center

class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0, maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = getLength(s, i, i);
            int len2 = getLength(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            
            if(maxLen > maxLength){
                maxLength = maxLen;
                start = i - (maxLen - 1)/2;
                end = start + maxLen;
            }
        }
        return s.substring(start, end);
    }
    
    private int getLength(String s, int start, int end){
        int L = start, R = end;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}