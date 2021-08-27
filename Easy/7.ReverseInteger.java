class Solution {
    public int reverse(int x) {
        int result = 0, temp;
        while(x != 0){
            temp = x % 10;
            x = x / 10;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && temp > 7)) return 0;
            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && temp < -8)) return 0;
            result = result * 10 + temp;
        }
        return result;
    }
}