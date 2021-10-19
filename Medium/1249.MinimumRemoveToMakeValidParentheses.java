class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(str.length());
            }
            if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    continue;
                }
            }
            str.append(c);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            str.deleteCharAt(index);
        }
        return str.toString();
    }
}