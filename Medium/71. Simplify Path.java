class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<String>();
        for (String str: path.split("/")) {
            if (str.equals("..")) {
                if (deque.size() != 0) {
                    deque.pollLast();
                }
            } else if (!str.equals(".") && !str.equals("")) {
                deque.offer(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.size() == 0)
            return "/";
            
        while (deque.size() != 0) {
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}

// Time complexity: O(n)
// Space complexity: O(n)