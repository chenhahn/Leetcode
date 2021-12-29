class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        int count = 1;
        int length = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[length++] = chars[i - 1];
                if (count <= 1) continue;
                int start = length;
                while (count > 0) {
                    chars[length++] = (char) ((count % 10) + '0'); 
                    count /= 10;
                }
                swap(chars, start, length - 1);
                count = 1;
            }
        }
        return length;
    }
    
    public void swap(char[] chars, int startIndex, int endIndex) {
        int start = startIndex, end = endIndex;
        while(start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp; 
            start++;
            end--;
        }
    }
}

// O(n) time O(1) space