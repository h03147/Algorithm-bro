package part_1.medium.dp;

public class DicesProbability60 {

    public double[] dicesProbability(int n) {
        /**
         * 动态规划的解法
         * dp[i][j] 代表前 i 个骰子的点数和 j 的概率，并执行状态转移
         * 而由于 dp[i] 仅由 dp[i−1] 递推得出，为降低空
         * 间复杂度，只建立两个一维数组 dp , tmp 交替前进即可
         * 时间复杂度O(n^2)，空间复杂度O(n)
         */
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for(int i = 2; i <= n; ++i) {
            double[] tmp = new double[5 * i + 1];
            for(int j = 0; j < dp.length; ++j) {
                for(int k = 0; k < 6; ++k) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

}
