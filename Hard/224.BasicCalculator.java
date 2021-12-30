class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign= 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                sign = stack.pop();
                int preResult = stack.pop();
                result = preResult + sign * result;
                number = 0;
                sign = 1;
            }
        }
        result += sign * number;
        return result;
    }
}