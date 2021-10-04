class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return new ArrayList<>();
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word: words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        int length = words[0].length();
        int count = words.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= s.length() - length * count; i++){
            Map<String, Integer> seenWords = new HashMap<>();
            for(int j = 0; j < count; j++){
                String word = s.substring(i + j * length, i + j * length + length);
                
                if(!frequencyMap.containsKey(word)) break;
            
                seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
            
                if(seenWords.get(word) > frequencyMap.getOrDefault(word, 0)) break;
                
                if(j == count - 1) result.add(i);
            }  
        }
        return result;
    }
}