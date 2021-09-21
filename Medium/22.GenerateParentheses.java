class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    public void helper(List<String> result, StringBuilder current, int open, int close, int n){
        if(open + close == 2 * n){
            result.add(current.toString());
            return;
        }
        
        if(open < n){
            current.append("(");
            helper(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }
        
        if(open > close){
            current.append(")");
            helper(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}