package part_1.medium.dp;

public class MaxProfit714 {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new MaxProfit714().maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        // 获得价格表的长度，用于遍历
        int n = prices.length;
        // 开辟一个二维数组给动态规划做准备,因为有两个条件需要分析，即每天的价格
        // 对应都有持有和不持有两种状态，故需要从二维的角度去拆分理解问题
        // int[][] dp = new int[n][2];
        // 第0天初始利润值 要么买入(持有)，要么先观望不买(不持有)
        // dp[0][0] = 0;
        // 刚开始就买此时持有收益就是负的，先砸钱才有可能赚钱
        // dp[0][1] = -prices[0];
        // 重点来了，分析一个循环周期内的所有可能情况并找到最大收益
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for(int i = 1;i < n; ++i)
        {
            // 第i天手上没有股票时的利润, 有两种可能
            // 1.前一天手上也没有股票时的利润，手里没股票可赚收益，所以今天和昨天利润一样保持不变
            // 2.前一天手上持有股票的利润，手里还有只股票，今天行情不错，老实掏手续费卖了增大囊中钱财!
            // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            // 第i天手上有股票的利润，也有两种可能
            // 1.前一天就买了，但是今天行情不太好，卖了肯定亏，我再忍忍，继续保持持有不卖
            // 2.前一天并没有买，处于今天可以买股票的状态，恰巧这只股票如果今天买入价格非
            // 常低，并且我相信买了一定稳赚，以今日股市价格砸钱买一点也无妨~
            // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }
        // 最后的最大利润肯定是全部套现收入囊中的才算最大利润，其他的什么再等等，未来还会
        // 涨都是虚的，都是屁话，我就不相信。
        // return dp[n-1][0];
        return dp[0];
    }

}
