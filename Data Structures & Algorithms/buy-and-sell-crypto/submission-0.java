class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            dp[i + 1] = Math.max(dp[i] - prices[i] + prices[i + 1], 0);
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}
