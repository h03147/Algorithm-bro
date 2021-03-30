package part_1.medium.dp;

public class CoinChange322 {

    public static void main(String[] args) {
        System.out.println(new CoinChange322().coinChange(new int[] {1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        /*
         * 分析题意：因为硬币可以重复使用，因此这是一个完全背包问题。完全背包只需要
         * 将 0-1 背包的逆序遍历 dp 数组改为正序遍历即可。
         */

        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for(int coin : coins) {
            // 将逆序遍历改成正序遍历
            for(int j = coin; j <= amount; ++j) {
                if(j == coin) {
                    // 如果j恰好等于当前面值coin，那就当前j下要1个硬币coin
                    dp[j] = 1;
                } else if(dp[j] == 0 && dp[j - coin] != 0) {
                    dp[j] = dp[j - coin] + 1;
                } else if(dp[j - coin] != 0) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        // 最后如果amount金额下有满足其条件下的硬币个数，就返回其个数否则找不到合适的就返回-1
        return dp[amount] == 0 ? -1 : dp[amount];
    }

}
