class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}

// Time complexity: O(n)	-> we go through the string of length n two times
// Space complexity: O(1)   -> English alphabet contains 26 letters