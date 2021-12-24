class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] pres = new int[length];
        int[] suffixs = new int[length];
        pres[0] = 1;
        suffixs[length - 1] = 1;
        for(int i = 1; i < length; i++) {
            pres[i] = pres[i - 1] * nums[i - 1];
        }
        for(int i = length - 2; i >= 0; i--) {
            suffixs[i] = suffixs[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < length; i++) {
            result[i] = pres[i] * suffixs[i];
        }
        return result;
    }
}
//time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int suffix = 1;
        int[] result = new int[length];
        result[0] = 1;
        for(int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        for(int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        return result;
    }
}
//time complexity: O(n)
//Space complexity: O(1)