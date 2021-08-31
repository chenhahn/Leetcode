class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = 200;
        StringBuilder result = new StringBuilder();
        for(String str: strs){
            min = Math.min(min, str.length());
        }
        
        for(int i = 0; i < min; i++){
            boolean flag = true;
            for(String str: strs){
                if(str.charAt(i) != strs[0].charAt(i)){
                    flag = false;
                }
            }
            if(flag == true){
                result.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return result.toString();
    }
}