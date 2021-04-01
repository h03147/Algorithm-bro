package part_1.hard.dp;

public class MaxProfit188 {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        System.out.println(new MaxProfit188().maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        if(k >= n / 2) {
            int maxProfit = 0;
            for(int i = 1; i < n; ++i) {
                if(prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];

        for(int i = 1; i <= k; ++i) {
            // 当前手上持有股票，初始情况下第一次交易，想持有，只能以第零天的价格买入
            int localMax = dp[i - 1][0] - prices[0];
            for(int j = 1; j < n; ++j) {
                // 第i比交易后，手上没有股票了, 要么是第j - 1天手上就已经完成了i比交
                // 易不持有了，要么是i - 1次交易时手上还持有，第j天以prices[j]卖出了
                // 完成第i比交易后手上不持有
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
                // 第i比交易后，手上还持有一只股票，要么是i - 1次交易后手上已经持有了，
                // 要么是i - 1次交易后手上没持有，第i次交易以价格j买入持有
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

}
