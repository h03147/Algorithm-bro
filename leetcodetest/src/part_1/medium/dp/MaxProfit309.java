package part_1.medium.dp;

public class MaxProfit309 {

    public static void main(String[] args) {
        System.out.println(new MaxProfit309().maxProfit(new int[] {1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        // // 方法一 动态规划
        // if(prices == null || prices.length ==0) return 0;
        // int n = prices.length;
        // int[][] dp = new int[n][3];
        // // 搞清楚下面三个状态很重要！！！
        // // dp[i][0]: 第i天收盘后手上还持有一只股票时的累计最大收益
        // // dp[i][1]: 第i天收盘后手上没有持有股票但是处于冷冻期时的累计最大收益
        // // dp[i][2]: 第i天收盘后手上没有股票并且不是冷冻期时的累计最大收益

        // // 第0天分析上面三种可能的状态
        // // 第0天是dp[0][0] = -price[0] (第零天是起始天，你手上持有股票只有可能
        // // 是当天开盘后现买的股票，买东西花钱所以是负收益)
        // // 再来想想剩下的两个状态dp[0][1] dp[0][2] 处于冷冻期的条件是之前手上已
        // // 经买了股票并且在前一天已经卖出了，而第0天你不买股票当然也不是冷冻期，所
        // // 以第0天这两种状态下累计最大收益都是0，没有意义所以我们可以省略
        // dp[0][0] = -prices[0];

        // // 剩下就可以开始从第1天遍历动态规划转移方程了
        // // 第i天做的所有操作都取决于第 i - 1 天的状态
        // for(int i = 1; i < n; ++i) {
        //     // 状态一：第i天手上持有股票，要么是第i - 1天手上就持有了。要么是第i - 1
        //     // 天手上没股票并且不是冷冻期那就第i天收盘前先买所以要减去price[i]
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
        //     // 状态二:第i天手上没股票并且属于冷冻期，那么说明只有第i - 1天手上持有
        //     // 了一只股票，在第i天收盘前卖掉，收盘后第i天才能进入冷冻期
        //     dp[i][1] = dp[i - 1][0] + prices[i];
        //     // 状态三：第i天收盘后手上没股票也不是冷冻期，说明要么第i - 1天是冷冻期，
        //     // 第i天就解冻了并且手上没股票，要么就是第第i - 1天就不持有股票也不是冷
        //     // 冻期
        //     dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        // }

        // // 为什么不考虑第n天手上还持有一只股票的状态一呢，因为落袋为安，都到最后一天了你还拿到手上不卖出，
        // // 没转换成钱，它就只是股票份额，何来的收益
        // return Math.max(dp[n - 1][1], dp[n - 1][2]);

        // 方法二 空间优化后的动态规划
        // 注意到上面的状态转移方程中，f[i][..] 只与 f[i−1][..] 有关，而与 f[i−2][..] 及之前的所有状
        // 态都无关，因此我们不必存储这些无关的状态。也就是说，我们只需要将 f[i−1][0]，f[i-1][1]，f[i−1][2]
        // 存放在三个变量中，通过它们计算出 f[i][0]，f[i][1]，f[i][2] 并存回对应的变量

        if(prices == null || prices.length == 0) return 0;

        int n = prices.length;
        // 初始化三个状态
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;

        for(int i = 1; i < n; ++i) {
            int nextdp0 = Math.max(dp0, dp2 - prices[i]);
            int nextdp1 = dp0 + prices[i];
            int nextdp2 = Math.max(dp1, dp2);
            dp0 = nextdp0;
            dp1 = nextdp1;
            dp2 = nextdp2;

        }

        return Math.max(dp1, dp2);

    }

}
