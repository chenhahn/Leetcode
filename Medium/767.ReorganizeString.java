class Solution {
    public String reorganizeString(String s) {
        int[] charMap = new int[26];
        char c;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            charMap[c - 'a'] += 1;
            if (max == -1 || charMap[c - 'a'] > charMap[max]) {
                max = c - 'a';
            }
        }
        if (charMap[max] > (s.length() + 1) / 2)
            return "";
        char[] result = new char[s.length()];
        int index = 0;
        while (charMap[max] > 0) {
            result[index] = (char)(max + 'a');
            charMap[max]--;
            index += 2;
        }
        for (int i = 0; i < 26; i++) {
            while (charMap[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = (char)(i + 'a');
                charMap[i]--;
                index += 2;
            }
        }
        return String.valueOf(result);
    }
}