class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0)
                    break;
                if(dp[i] > dp[i - coins[j]] + 1)
                    dp[i] = dp[i - coins[j]] + 1;
            }
        }
        return dp[amount] > amount ?  -1 : dp[amount];
    }
}

// Time complexity: O(n * amount)	n -> total kinds of coins provided;	amount -> amount to make change for;
// Space complexity: O(amount)	we cache (amount + 1) subproblems' answers