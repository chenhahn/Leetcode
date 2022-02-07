class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int m, n;
            m = i >= 0 ? a.charAt(i) - '0' : 0;
            n = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = m + n + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

// Time complexity: O(Max(|A|,|B|))
// Space complexity: O(Max(|A|,|B|))