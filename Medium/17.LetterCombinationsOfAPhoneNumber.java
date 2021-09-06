class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return List.of();
        List<String> result = new ArrayList<String>();
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(result, map, "", digits, 0);
        return result;
    }

    public void helper(List<String> result, String[] map, String str, String digits, int index){
        int digit = digits.charAt(index) -'0';
        String tempStr;
        for(int i = 0; i < map[digit - 2].length(); i++){
            tempStr = str + map[digit - 2].charAt(i);
            if(index == digits.length() - 1){
                result.add(tempStr);
                continue;
            }
            helper(result, map, tempStr, digits, index + 1);
        }
        return;
    }
}
