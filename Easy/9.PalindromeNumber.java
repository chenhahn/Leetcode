class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x, reversedNum = 0, digit;
        while(num > 0){
            digit = num % 10;
            num = num / 10;
            reversedNum = reversedNum * 10 + digit;
        }
        return reversedNum == x ? true : false;
    }
}