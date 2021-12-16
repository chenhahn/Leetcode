class Solution {
    public int expressiveWords(String str, String[] words) {
        int count = 0;
        for (String word: words) {
            if(isStretchy(str, word)) {
                count++;
            }            
        }
        return count;
    }
    
    public boolean isStretchy(String str, String word) {
        if (word.length() == 0) return false;
        int i = 0, j = 0;
        while (i < str.length() && j < word.length()) {
            if (str.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedLength(str, i);
                int len2 = getRepeatedLength(word, j);
                if(len1 == len2 || len1 >= 3 && len1 > len2) {
                    i += len1;
                    j += len2;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i == str.length() && j == word.length();
    }
    
    public int getRepeatedLength(String str, int i) {
        int j = i;
        while (j < str.length() && str.charAt(i) == str.charAt(j)) {
            j++;
        }
        return j - i;
    }
}