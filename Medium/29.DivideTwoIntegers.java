class Solution {
    public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    if (divisor == 1) {
      return dividend;
    }
    boolean isNegative = false;
    if (dividend < 0 && divisor > 0 || (dividend > 0 && divisor < 0)) {
      isNegative = true;
    }
    dividend = (dividend > 0) ? -dividend : dividend;
    divisor = (divisor > 0) ? -divisor : divisor;
    int result = 0;
    while(dividend <= divisor) {
      dividend = dividend - divisor;
      result++;
    }
    return isNegative ? -result : result;
    }
}