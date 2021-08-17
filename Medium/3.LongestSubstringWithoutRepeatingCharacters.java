class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max = 0;
        int length = 0;
        HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();
        while(j < s.length() && i <= j){
            char c = s.charAt(j);
            if(indexMap.containsKey(c) && i <= indexMap.get(c)){
                i = indexMap.get(c) + 1;
            }
            length = j - i + 1; 
            if(length > max){
                max = length;
            }
            indexMap.put(c, j);
            j++;
        }  
        return max;
    }
}