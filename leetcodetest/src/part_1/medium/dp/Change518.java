package part_1.medium.dp;

public class Change518 {

    public static void main(String[] args) {
        System.out.println(new Change518().change(5, new int[] {1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int j = coin; j <= amount; ++j) {
                // 之前做完全背包问题是比较并只存储一个要么数量最大或最小，这里是全部都要即累加，所以
                // 是dp[j] = dp[j] + dp[j - coin];
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }

}
