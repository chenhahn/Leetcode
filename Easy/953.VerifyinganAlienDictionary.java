class Solution {
    int[] orderMap;
    public boolean isAlienSorted(String[] words, String order) {
        orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]) > 0) 
                return false;
        }
        return true;
    }
    
    public int compare(String word1, String word2) {
        int i = 0;
        int diff = 0;
        while (i < word1.length() && i < word2.length() && diff == 0) {
            diff = orderMap[word1.charAt(i) - 'a'] - orderMap[word2.charAt(i) - 'a'];
            
            i++;
        }
        
        if (diff == 0) {
            return word1.length() - word2.length();
        }
        
        return diff;
    }
}

// Time complexity: O(M * N), M -> number of words; N -> largest number of letters in a word
// Space complexity: O(1), space cost of orderMap is fixed as 26.