class Solution {
    public int myAtoi(String s) {
        boolean isNegative = false;
        int startIndex = 0, result = 0, curDigit = 0;
        //string with white space removed 
        String wsrs = s.trim();
        
        if(wsrs == null || wsrs.length() == 0){
            return 0;
        }
        
        if(wsrs.charAt(0) == '-'){
            isNegative = true;
            startIndex++;
        }else if(wsrs.charAt(0) == '+'){
            startIndex++;
        }
        
        for(int i = startIndex; i < wsrs.length() && Character.isDigit(wsrs.charAt(i)); i++){
            curDigit = wsrs.charAt(i) - 48;
            if(isNegative && (result > Integer.MIN_VALUE / -10 || (result == Integer.MIN_VALUE / -10 && curDigit > 8))) return Integer.MIN_VALUE;
            if(!isNegative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && curDigit > 7))) return Integer.MAX_VALUE;
            result = result * 10 + curDigit;
        }
        return isNegative ? -result : result;
    }
}