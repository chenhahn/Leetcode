class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(number);
                } else if (operator == '-') {
                    stack.push(-number);
                } else if (operator == '*') {
                    stack.push(stack.pop() * number);
                } else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }
                operator = c;
                number = 0;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
// Time complexity: O(n)
// Space complexity: O(n)