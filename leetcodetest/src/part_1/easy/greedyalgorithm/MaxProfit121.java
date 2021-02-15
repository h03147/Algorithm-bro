package part_1.easy.greedyalgorithm;

public class MaxProfit121 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int size = prices.length;

        // 初始情况，取第一个交易日股票价格为最小买入价格
        int min_buy = prices[0];
        int max_profit = 0;

        for(int i = 1; i < size; ++i) {
            if(prices[i] < min_buy) {
                min_buy = prices[i];
            } else {
                // 只要第二天卖出去能不亏本，我们就记一次当天卖出的收益
                // 来比较每一次的正收益，保留最大值即为结果。
                max_profit = Math.max(max_profit, prices[i] - min_buy);
            }
        }
        return max_profit;
    }
}
