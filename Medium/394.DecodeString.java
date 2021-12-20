class Solution {
    public String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c: s.toCharArray()) queue.add(c);
        return helper(queue);
    }
    
    private String helper(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.remove();
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String st = helper(queue);
                for (int i = 0; i < num; i++) sb.append(st);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}