package part_1.easy.greedyalgorithm;

public class MaxProfit122 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        /*
         * 只要有正收益，我们就做t + 1日的交易卖出，每天偶读有可能买，
         * 每天都有可能卖，只要前一天买入今天卖有正收益我们就算一次
         * 收益，最后累计总和就是最大收益。
         */

        int total_profit = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] - prices[i - 1] > 0) {
                total_profit += prices[i] - prices[i - 1];
            }
        }
        return total_profit;
    }
}
