class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<CharCount> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty() || stack.peek().c != c) {
                stack.push(new CharCount(c));
            } else {
                if (stack.peek().count == k - 1) {
                    stack.pop();
                    continue;
                }
                stack.peek().count++;
            }
        }
        
        for (CharCount cc: stack) {
            int count = cc.count;
            while(count > 0) {
                sb.append(cc.c);
                count--;
            }
        }
        
        return sb.toString();
    }
    
    class CharCount {
        char c;
        int count;
        public CharCount(char c) {
            this.c = c;
            this.count = 1;
        }
    }
}

// Time complexity: O(n)
// Space complexity: O(n)