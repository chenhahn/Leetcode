class Solution {
    public String convert(String s, int numRows) {
        int curRow = 0, dir = 1;
        String result = "";
        
        if(numRows == 1) return s;
        
        StringBuilder[] sbs = new StringBuilder[numRows];
        
        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sbs[curRow].append(c);
            curRow += dir;
            if(curRow == 0 || curRow == numRows - 1){
                dir = -dir;
            }
        }
        for(StringBuilder sb: sbs){
            result += sb.toString();
        }
        return result;
    }
}